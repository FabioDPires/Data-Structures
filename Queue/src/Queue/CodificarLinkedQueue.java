/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Queue;

import Exceptions.EmptyCollectionException;


public class CodificarLinkedQueue {
    private QueueADT <Integer> chave;
    private QueueADT <Character> mensagemCodificada;
    private QueueADT <Character> mensagemDescodificada;
    private char[] nMensagem;

    public CodificarLinkedQueue(String mensagem) {
        this.nMensagem=mensagem.toCharArray();
        mensagemCodificada=new LinkedQueue<Character>();
        mensagemDescodificada=new LinkedQueue<Character>();
        this.chave=new CircularArrayQueue<Integer>(5);
        for(int i=2;i<7;i++){
            chave.enqueue(i);
        }
         
        
    }
   
        public void descodificar() throws EmptyCollectionException{
            int avancos;
            for(int i=0;i<nMensagem.length;i++){
                char c=nMensagem[i];
                mensagemCodificada.enqueue(c);
            }
            System.out.println("Mensagem codificada: "+ mensagemCodificada.toString());
            while(mensagemCodificada.isEmpty()==false){
                char caracter=mensagemCodificada.dequeue();
                avancos=chave.dequeue();
                chave.enqueue(avancos);
                caracter=(char) (caracter+avancos);
                mensagemDescodificada.enqueue(caracter);
                
            }
            System.out.println("Chave: "+chave.toString());
            System.out.println("Mensagem descodificada: "+mensagemDescodificada.toString());
        }
    
}
