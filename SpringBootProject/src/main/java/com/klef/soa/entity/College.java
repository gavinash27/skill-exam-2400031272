package com.klef.soa.entity;


import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
  @Entity
  @Table(name = "college_table")
  @Data
  public class College 
  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cid"  )
	private long collegeId;
    @Column(name = "cname", length = 100, nullable = false)
	private String name;
    @Column(name = "ctype", length = 100, nullable = false)
	private String type;
    @Column(name = "cstatus", nullable = false)
	private boolean status;
    @Column(nullable = false)
	private String location;
	
    @CreationTimestamp
	private LocalDateTime createdAt;
    @UpdateTimestamp
	private LocalDateTime updatedAt;
  }