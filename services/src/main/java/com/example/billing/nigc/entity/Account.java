package com.example.billing.nigc.entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.kie.api.io.ResourceType;
import org.kie.internal.KnowledgeBase;
import org.kie.internal.KnowledgeBaseFactory;
import org.kie.internal.builder.DecisionTableConfiguration;
import org.kie.internal.builder.DecisionTableInputType;
import org.kie.internal.builder.KnowledgeBuilder;
import org.kie.internal.builder.KnowledgeBuilderFactory;
import org.kie.internal.io.ResourceFactory;
import org.kie.internal.runtime.StatelessKnowledgeSession;

import javax.annotation.PostConstruct;
import javax.persistence.*;
import java.io.Serializable;
/**
 * Created By: Ali Mohammadi
 * Date: 15 May, 2022
 */
@Entity(name = "Account")
@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class Account implements Serializable {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
  private String name;
  private String lastName;
  private int age;
  private String address;
  private String amount;
  @Transient
  private String newAmount;
  public void addNewAmount(Integer amount){
    Integer a=Integer.valueOf(this.amount);
    newAmount=String.valueOf(a+amount);
  }

  
  @Override
  public String toString() {
    return "Account{" +
    "id=" + id +
    ", name='" + name + '\'' +
    ", lastName='" + lastName + '\'' +
    ", age=" + age +
    ", address='" + address + '\'' +
    ", amount='" + amount + '\'' +
    ", newAmount='" + newAmount + '\'' +
    '}';
  }
}
