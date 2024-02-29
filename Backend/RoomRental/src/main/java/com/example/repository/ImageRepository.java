package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entity.Image;

public interface ImageRepository extends JpaRepository<Image, Integer> {

}
