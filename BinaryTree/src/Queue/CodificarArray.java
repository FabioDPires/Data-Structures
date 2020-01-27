/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Queue;

import Exceptions.EmptyCollectionException;

/**
 *
 * @author fabio
 */
public class CodificarArray {

    private QueueADT<Integer> chave ;
    private QueueADT<Character> mensagemCodificada;
    private QueueADT<Character> mensagemDescodificada;
    private char[] nMensagem;

    public CodificarArray() {
        chave= new CircularArrayQueue<Integer>(5);
        for (int i=2;i<7;i++){
            chave.enqueue(i);
        }
       
    }

    public CodificarArray(String mensagem) {
        chave= new CircularArrayQueue<Integer>(5);
       for (int i=2;i<7;i++){
            chave.enqueue(i);
        }

        nMensagem = mensagem.toCharArray();
        mensagemCodificada = new CircularArrayQueue<Character>(mensagem.length());
        mensagemDescodificada = new CircularArrayQueue<Character>(mensagem.length());

    }

    public void descodificar() throws EmptyCollectionException {
          
        int avancos;
        for (int i = 0; i < nMensagem.length; i++) {
            char c = nMensagem[i];
            mensagemCodificada.enqueue(c);
        }
        System.out.println("Mensagem Codificada:\n " + mensagemCodificada.toString());

        while (mensagemCodificada.isEmpty() == false) {
            char character = mensagemCodificada.dequeue();
            avancos = chave.dequeue();
            chave.enqueue(avancos);
            character = (char) (character + avancos);
            mensagemDescodificada.enqueue(character);

        }
        
        System.out.println("Chave:\n " +chave.toString());
        System.out.println("Mensagem Descodificada:\n " + mensagemDescodificada.toString());
    }

}
