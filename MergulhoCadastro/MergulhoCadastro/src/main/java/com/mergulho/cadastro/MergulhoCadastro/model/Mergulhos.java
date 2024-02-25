package com.mergulho.cadastro.MergulhoCadastro.model;

import jakarta.persistence.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;



@Entity
@Table(name = "MergulhoDB")
public class Mergulhos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_Certificado")
    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "Curso", length = 200, nullable = false)
    String Curso;
    @Column(name = "Data_de_Certificacao")
    String Data;
    @Column(name = "Codigo_Certificado")
    String Codigo_Certificado;
    @Column(name = "Codigo_Certificado_Instrutor")
    String Codigo_Certificado_Instrutor;
    @Column(name = "Nome_Instrutor")
    String Nome_Instrutor;
    @Column(name = "Escola")
    String Escola;
    @Column(name = "Certificadora")
    String Certificadora;

    public void executarInsercao(Connection connection) {
        try {
            String sql = "INSERT INTO MergulhoDB (Curso, Data_de_Certificacao, Codigo_Certificado, Codigo_Certificado_Instrutor, Nome_Instrutor, Escola, Certificadora) VALUES (?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, Curso);
            statement.setString(2, Data);
            statement.setString(3, Codigo_Certificado);
            statement.setString(4, Codigo_Certificado_Instrutor);
            statement.setString(5, Nome_Instrutor);
            statement.setString(6, Escola);
            statement.setString(7, Certificadora);

            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("Dados inseridos na tabela 'Mergulho' com sucesso.");
            } else {
                System.out.println("Falha ao inserir os dados na tabela 'Mergulho'.");
            }
        } catch (SQLException e) {
            System.out.println("Erro ao inserir os dados: " + e.getMessage());
        }
    }

    public String getCurso() {
        return Curso;
    }

    public void setCurso(String curso) {
        Curso = curso;
    }

    public String getData() {
        return Data;
    }

    public void setData(String data) {
        Data = data;
    }

    public String getCodigo_Certificado() {
        return Codigo_Certificado;
    }

    public void setCodigo_Certificado(String codigo_Certificado) {
        Codigo_Certificado = codigo_Certificado;
    }

    public String getCodigo_Certificado_Instrutor() {
        return Codigo_Certificado_Instrutor;
    }

    public void setCodigo_Certificado_Instrutor(String codigo_Certificado_Instrutor) {
        Codigo_Certificado_Instrutor = codigo_Certificado_Instrutor;
    }

    public String getNome_Instrutor() {
        return Nome_Instrutor;
    }

    public void setNome_Instrutor(String nome_Instrutor) {
        Nome_Instrutor = nome_Instrutor;
    }

    public String getEscola() {
        return Escola;
    }

    public void setEscola(String escola) {
        Escola = escola;
    }

    public String getCertificadora() {
        return Certificadora;
    }

    public void setCertificadora(String certificadora) {
        Certificadora = certificadora;
    }
}
