/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RSA;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.StringTokenizer;

/**
 *
 * @author Mvami N. Jonalex
 */
public class Fichier {
    
    private BufferedWriter bfW;
    private BufferedReader bfR;
    private String fileUrl;
    
    public void setFileUrl(String tmp){
        fileUrl = tmp;
    }
    
    public String getFileUrl(){
        return fileUrl;
    }
    
    public boolean  openInRead(String url) {
	try {
            setFileUrl(url);
            File f = new File(fileUrl);
	    bfR  = new BufferedReader(new FileReader(f));
            bfW = null;
            return true;
	}
	catch (IOException err)	{
                System.out.println(fileUrl+" : Erreur  à l'ouverture en lecture");
		return false;
	}
    }
    
    public String read() {
        try {
            String chaine = bfR.readLine();
            return chaine;
        }
        catch (IOException err) { 
		System.out.println(fileUrl+" : Erreur  de lecture ");
                return null;
	}
    }
    
    public String [] extractData(String tmp, String token)  {
        if (tmp != null) {
            StringTokenizer st = new StringTokenizer(tmp,token);
            int i=0;
            String word[] = new String[st.countTokens()];
            while (st.hasMoreTokens()) {
                word[i] = st.nextToken();
                i++;
            }
            return word;
        }
        else return null;
    }
    
     public boolean closeFile()  {
     // Try executing the following instructions :
     // If no error detected, execute instruction in try
     // else execute those in catch
     try {
       if (bfR != null) bfR.close();
       else  if (bfW != null) bfW.close();
       return true;
     }
      // Si une erreur est détéctée (le fichier n'existe pas, n'est pas ouvert, ...)
     catch (IOException err) {
         // afficher le message d'erreur
	System.out.println(fileUrl+" : Erreur  à la fermeture ");
        return false;
     }
 }
  // Ouvrir un fichier en écriture
  public boolean  openInWrite(String url) {
        // Essayer de réaliser les instructions suivantes :
        // Si aucune erreur n'est détectée, exécuter les instructions du bloc try
        // Sinon exécuter les instructions du bloc catch
	try {
            setFileUrl(url);
            File f = new File(fileUrl);
             // Création d'un flux en écriture ligne par ligne
	    bfW = new BufferedWriter(new FileWriter(f));
            bfR = null;
            return true;
	}
         // Si une erreur est détéctée (le fichier n'existe pas, ...)
	catch (IOException e)	{
                // afficher le message d'erreur
                System.out.println(fileUrl+" : Erreur  à l'ouverture en écriture ");
		return false;
	}
 }

 // Ecrire dans le flux ouvert en écriture ligne par ligne, passer à la ligne 
 public boolean write(String tmp) {
      // Essayer de réaliser les instructions suivantes :
      // Si aucune erreur n'est détectée, exécuter les instructions du bloc try
      // Sinon exécuter les instructions du bloc catch
      try {
 	if (tmp != null)   {
                // Ecrire lz chaine tmp du caractère 0 jusqu'à la fin du mot
		bfW.write(tmp,0,tmp.length());
                // Passer à la ligne suivante
		bfW.newLine();
	}
        return true;
        }
       // Si une erreur est détéctée (le fichier n'est pas ouvert en écriture
	catch (IOException err) {
                 // afficher le message d'erreur
		System.out.println(fileUrl+" : Erreur  d'écriture ");
                return false;
	}
   }
 
 public boolean writeL(String tmp) {
      // Essayer de réaliser les instructions suivantes :
      // Si aucune erreur n'est détectée, exécuter les instructions du bloc try
      // Sinon exécuter les instructions du bloc catch
      try {
 	if (tmp != null)   {
                // Ecrire lz chaine tmp du caractère 0 jusqu'à la fin du mot
		bfW.write(tmp,0,tmp.length());
	}
        return true;
        }
       // Si une erreur est détéctée (le fichier n'est pas ouvert en écriture
	catch (IOException err) {
                 // afficher le message d'erreur
		System.out.println(fileUrl+" : Erreur  d'écriture ");
                return false;
	}
   }
    
}
