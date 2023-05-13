/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import bean.DanhMucBean;
import bean.newbean;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JPanel;
import view.HoaDonJPanel;
import view.KhachHangJPanel;
import view.NhanVienJPanel;
import view.SanPhamJPanel;

/**
 *
 * @author uesr
 */
public class newfile {
    private JPanel root;
    private String kindSelectd = "";
    
    private List<newbean> listItem = null;

    public newfile(JPanel main) {
        this.root = main;
    }
    
    public void setView(JPanel jpnItem, JLabel jlbItem){
        root.removeAll();
        root.setLayout(new BorderLayout());
        root.repaint();
        root.validate();
    } 
    
    public void setEvent(List<newbean> listItem){
        this.listItem = listItem;
        
        for(newbean
                item : listItem){
            item.getJlb().addMouseListener(new LabelEvent(item.getKind(), item.getJlb()));
        }
    }
    
    class LabelEvent implements MouseListener{
        
        private JPanel node;
        private String kind;

        private JPanel jpnItem;
        private JLabel jlbItem;

        public LabelEvent(String kind, JLabel jlbItem) {
            this.kind = kind;
            this.jlbItem = jlbItem;
        }
        
        
        @Override
        public void mouseClicked(MouseEvent e) {
            switch (kind) {
                case "KhachHang":
                    node = new KhachHangJPanel();
                    break;
                case "SanPham":
                    node = new SanPhamJPanel();
                    break;
                case "NhanVien":
                    node = new NhanVienJPanel();
                    break;
                case "HoaDon":
                    node = new HoaDonJPanel();
                    break;
                default:
                    node = new NhanVienJPanel();
                    break;
            }
            
            root.removeAll();
            root.setLayout(new BorderLayout());
            root.add(node);
            root.repaint();
            root.validate();
            setChangeBackground(kind);
        }

        @Override
        public void mousePressed(MouseEvent e) {
        }

        @Override
        public void mouseReleased(MouseEvent e) {
        }

        @Override
        public void mouseEntered(MouseEvent e) {;
        }

        @Override
        public void mouseExited(MouseEvent e) {
        }
        private void setChangeBackground(String kind){
            for(newbean item : listItem){
                if(item.getKind().equalsIgnoreCase(kind)){
                    item.getJlb().setForeground(Color.red);
                }
                else{
                    item.getJlb().setForeground(Color.black);
                }
            }
        }
    }
}
