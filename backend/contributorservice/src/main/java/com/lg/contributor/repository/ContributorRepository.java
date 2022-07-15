package com.lg.contributor.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lg.contributor.entity.ContributorEntity;

@Repository
public interface ContributorRepository extends JpaRepository<ContributorEntity, String> {

}
