package ac.seacreature.acseacreatures.data.repository

import kotlinx.coroutines.flow.*
import ac.seacreature.acseacreatures.common.network.LoadingState
import ac.seacreature.acseacreatures.data.datasource.remote.service.INetworkService
import ac.seacreature.acseacreatures.datasource.local.db.SeaCreaturesDatabase
import ac.seacreature.acseacreatures.datasource.local.mapper.toSeaCreatureData
import ac.seacreature.acseacreatures.datasource.local.mapper.toSeaCreatureEntity
import ac.seacreature.acseacreatures.domain.model.SeaCreatureData
import ac.seacreature.acseacreatures.domain.repo.ISeaCreatureRepository

class SeaCreatureRepository(
    private val networkService: INetworkService,
    database: SeaCreaturesDatabase
) : ISeaCreatureRepository {

    private val seaCreatureDao = database.seaCreatureDao()

    override fun updateData(): Flow<LoadingState> = flow {
        emit(LoadingState.Loading)
        val seaCreatureData = networkService.getAllData()
        seaCreatureData.data?.let { seaCreatures ->
            seaCreatureDao.insertAll(seaCreatures.map { it.toSeaCreatureEntity() })
        }
        emit(seaCreatureData.loadingState)
    }

    override fun getSeaCreature(id: Int): Flow<SeaCreatureData> =
        seaCreatureDao.loadById(id).map {
            it.toSeaCreatureData()
        }

    override fun getSeaCreatures(): Flow<List<SeaCreatureData>> =
        seaCreatureDao.getAll().distinctUntilChanged()
            .map { list -> list.map { it.toSeaCreatureData() } }
}
