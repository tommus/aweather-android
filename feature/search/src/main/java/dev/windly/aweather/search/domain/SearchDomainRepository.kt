package dev.windly.aweather.search.domain

import dev.windly.aweather.search.SearchCriteria
import dev.windly.aweather.search.SearchRepository
import dev.windly.aweather.search.network.SearchNetworkRepository
import dev.windly.aweather.search.persistence.SearchPersistenceRepository
import io.reactivex.rxjava3.core.Flowable
import javax.inject.Inject

class SearchDomainRepository @Inject constructor(
  private val mapper: SearchMapper,
  private val network: SearchNetworkRepository,
  private val persistence: SearchPersistenceRepository,
) : SearchRepository {

  // TODO: 13.03.2023 Compose a search domain repository.

  override fun execute(criteria: SearchCriteria): Flowable<List<Any>> =
    Flowable.empty()
}
