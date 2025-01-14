package sn.ism.auchan.data.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@MappedSuperclass
public class AbstractType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;
    @Column(nullable = false, unique = true, length = 50)
    protected String name;
    @Column(nullable = false, unique = true, length = 50)
    protected String code;
}
