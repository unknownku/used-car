package com.oot.usedcar.domain;

import javax.persistence.Entity; 
import javax.persistence.GeneratedValue; 
import javax.persistence.GenerationType; 
import javax.persistence.Id; 
import javax.persistence.Table; 
 
@Entity 
@Table(name = "Province") 

public class Province {
    private Long id; 
    private String nameth; 
    private String nameen; 
     
    @Id 
    @GeneratedValue(strategy = GenerationType.AUTO) 
    public Long getId() { 
      return id; 
    } 
    public void setId(Long id) { 
      this.id = id; 
    } 
    public String getNameth() { 
      return nameth; 
    } 
    public void setNameth(String nameth) { 
      this.nameth = nameth; 
    } 
    public String getNameen() { 
      return nameen; 
    } 
    public void setNameen(String nameen) { 
      this.nameen = nameen; 
    } 

}
