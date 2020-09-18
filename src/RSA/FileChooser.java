/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RSA;

import java.io.File;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.JFrame;
import javax.swing.filechooser.FileFilter;

/**
 *
 * @author Mvami N. Jonalex
 */
public final class FileChooser {
    //<editor-fold defaultstate="collapsed" desc="constructor">
    public FileChooser(JFrame parent){
        this.filter = new FileNameExtensionFilter("text files", "txt");
        setFParent(parent);
        flag = true;
    }
    
    public FileChooser(JDialog parent){
        this.filter = new FileNameExtensionFilter("text files", "txt");
        setDParent(parent);
        flag = false;
    }
    
//</editor-fold>
    
    
    //<editor-fold defaultstate="collapsed" desc="properties">
    private File textFile;
    private String option;
    private String url;
    private boolean flag;
    private JFrame fParent;
    private JDialog dParent;
    
    private FileNameExtensionFilter filter;

//</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="set methods">
    private void setOption(String tmp) {
        option = tmp;
    }
    
    public void setUrl(String tmp){
        url = tmp;
    }
    
    public void setFParent(JFrame parent) {
        fParent = parent;
    }

    public void setDParent(JDialog parent) {
        dParent = parent;
    }
    
//</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="get methods">
    public String getUrl(){
        return url;
    }
    
    public String getOption(){
        return option;
    }
    
    public JFrame getFParent(){
        return fParent;
    }
    
    public JDialog getDParent(){
        return dParent;
    }
    
//</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="methods">
    public String openFile(){
        JFileChooser  chooser = new JFileChooser();
        chooser.removeChoosableFileFilter(chooser.getAcceptAllFileFilter());
        chooser.addChoosableFileFilter(filter);
//        chooser.resetChoosableFileFilters();
        if(flag){
            int ReturnState = chooser.showOpenDialog(getFParent());
            if(ReturnState == JFileChooser.APPROVE_OPTION){
                textFile = chooser.getSelectedFile();
                setUrl(textFile.toString());
            }
            else setUrl(null);
        }
        else{
            int ReturnState = chooser.showOpenDialog(getDParent());
            if(ReturnState == JFileChooser.APPROVE_OPTION){
                textFile = chooser.getSelectedFile();
                setUrl(textFile.toString());
            }
            else setUrl(null);
        }
        return getUrl();
    }
    
    public String saveFile(){
        JFileChooser chooser = new JFileChooser();
        chooser.removeChoosableFileFilter(chooser.getAcceptAllFileFilter());
        chooser.addChoosableFileFilter(filter);
        if(flag){
            int ReturnState = chooser.showSaveDialog(getFParent());
            if(ReturnState == JFileChooser.APPROVE_OPTION){
                textFile = chooser.getSelectedFile();
                setUrl(textFile.toString());
            }
            else setUrl(null);
        }
        else{
            int ReturnState = chooser.showSaveDialog(getDParent());
            if(ReturnState == JFileChooser.APPROVE_OPTION){
                textFile = chooser.getSelectedFile();
                setUrl(textFile.toString());
            }
            else setUrl(null);
        }
        return getUrl();
    }
//</editor-fold>

}

