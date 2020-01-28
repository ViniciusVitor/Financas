package com.example.Financas.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Financas.model.entity.Lancamento;

public interface LancamentoRepository extends JpaRepository<Lancamento, Long> {

}
