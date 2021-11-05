package com.wema.myprofile.infrastracture.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.wema.myprofile.infrastracture.entity.ProfileDto;

@Repository
public interface ProfileRepository extends JpaRepository<ProfileDto, Long> {

}
