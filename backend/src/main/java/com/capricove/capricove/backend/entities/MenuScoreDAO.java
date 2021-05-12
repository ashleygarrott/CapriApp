package com.capricove.capricove.backend.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "menuTally")
public class MenuTallyDAO {

    @Id
    @Column
    private int menuId;

    @Column
    private int 
}
