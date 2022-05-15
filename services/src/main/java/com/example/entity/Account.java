package com.example.entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
/**
 * Created By: Ali Mohammadi
 * Date: 15 May, 2022
 */
@Entity(name = "Account")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Account implements Serializable {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
  private String name;
  private String lastName;
}
