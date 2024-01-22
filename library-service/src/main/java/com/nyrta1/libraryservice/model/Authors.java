package com.nyrta1.libraryservice.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.beans.factory.annotation.Value;

import java.util.UUID;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Authors {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name="authorUUID", insertable = false, updatable = false, nullable = false)
    private UUID authorUUID;

    @Column(nullable = false)
    @Size(min = 3, max = 255)
    private String authorName;
}
