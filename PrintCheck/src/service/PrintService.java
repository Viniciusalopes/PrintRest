/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import static util.Util.getErrorMessage;

/**
 *
 * @author vinicius
 */
public class PrintService {

    public String print(String pDocumentName, int id) throws Exception {
        try {
            new CheckService().addPrint(id);
            return String.format("Imprimindo " + pDocumentName + ": %d", id);
        } catch (Exception e) {
            return String.format("Erro ao imprimir o " + pDocumentName + " %d: " + getErrorMessage(e), id);
        }
    }
}
