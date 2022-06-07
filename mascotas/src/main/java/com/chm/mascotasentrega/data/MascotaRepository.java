package com.chm.mascotasentrega.data;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.chm.mascotasentrega.model.Mascota;

public interface MascotaRepository extends PagingAndSortingRepository<Mascota, Long> {

}
