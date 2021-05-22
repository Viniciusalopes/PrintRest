/*
 *  ----------------------------------------------------------------------------------------------->
 *  Licença    : MIT - Copyright 2019 Viniciusalopes (Vovolinux) <suporte@vovolinux.com.br>
 *  Criado em  : 15/11/2020 19:47:48 
 *  Projeto    : LogFile
 *  Versão     : 0.0.1
 *  ------------------------------------------------------------------------------------------------
 *  Propósito  : Utilitários para informações do sistema operacional.
 *  ------------------------------------------------------------------------------------------------
 *  Changelog:
 *  Autor      : Vovolinux
 *  Data       : YYYY-mm-dd
 *  Versão     : n.n.n
 *  Alterações : DUPLICAR ESTE BLOCO E DESCREVER A(s) ALTERAÇÃO(ões) RELEVANTES PARA A VERSÃO.
 *               MANTER INDENTAÇÃO DE LINHAS ABAIXO DA PRIMEIRA LINHA E O LIMITE DE COLUNAS AQUI -->
 *  -----------------------------------------------------------------------------------------------| 
 */
package util;

/**
 *
 * @author vovolinux
 */
public class UtilSo {

    public static String getCurrentUser() throws Exception {
        return System.getProperty("user.name");
    }

    public static String getCurrentDir() throws Exception {
        return new java.io.File(".").getCanonicalPath().replace("/", getBar());
    }

    public static String getSo() {
        return System.getProperty("os.name");
    }

    public static String getBar() {
        return (getSo().toLowerCase().contains("windows") ? "\\" : "/");
    }
}
