package com.example.buffetmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.buffetmanagement.model.*;
public interface BuffetEventRepository extends JpaRepository<BuffetEvent, Long> {}
