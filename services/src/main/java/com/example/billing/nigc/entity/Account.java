package com.example.billing.nigc.entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
//import org.hibernate.annotations.Cache;
//import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
@Entity(name = "Account")
@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
//@Cache(usage = CacheConcurrencyStrategy.READ_ONLY, region = "account")
public class Account implements Serializable {
  
  /*  @GeneratedValue(generator = "my-generator")
    @GenericGenerator(name = "my-generator",
    parameters = @Parameter(name = "prefix", value = "4000"),
    strategy = "com.example.billing.nigc.utils.MyGenerator")*/
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
  private String name;
  private String lastName;
  private Integer age;
  private String address;
  private String amount;
  //@Transient
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
