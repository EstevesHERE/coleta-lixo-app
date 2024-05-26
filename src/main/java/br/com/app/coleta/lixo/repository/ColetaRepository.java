package br.com.app.coleta.lixo.repository;

import br.com.app.coleta.lixo.models.Coleta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ColetaRepository  extends JpaRepository<Coleta, Long> {
}
