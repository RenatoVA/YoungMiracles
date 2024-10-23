package com.grupo1software.youngmiracles.model.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class PasswordResetToken {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotNull
    @Size(min=32, max=64)
    @Column(nullable = false, unique = true)
    private String token;
    @NotNull
    @Column(nullable = false)
    private LocalDateTime expiration;
    @NotNull
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "usuario_id", nullable = false, referencedColumnName = "id",foreignKey = @ForeignKey(name="FK_PASSWORDRESETTOKEN_USUARIO"))
    private Usuario usuario;
    public void setExpiration(int minutes) {
        this.expiration = LocalDateTime.now().plusMinutes(minutes);
    }
    public boolean isExpired() {
        return LocalDateTime.now().isAfter(expiration);
    }
}
