/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;
import bean.DanhMucBean;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JPanel;
import view.frmHoaDon;
import view.frmKhachHang;
import view.frmNhanVien;
import view.frmSanPham;
import view.frmThongKe;

/**
 *
 * @author uesr
 */
public class ChuyenManHinhControl {
    private JPanel root;
    private String kindSelectd = "";
    
    private List<DanhMucBean> listItem = null;

    public ChuyenManHinhControl(JPanel root) {
        this.root = root;
    }
    
    public void setView(JPanel jpnItem, JLabel jlbItem){
        kindSelectd = "NhanVien";
        jpnItem.setBackground(new Color(96,100,191));
        jlbItem.setBackground(new Color(96,100,191));
        
        root.removeAll();
        root.setLayout(new BorderLayout());
//        root.add(new frmNhanVien());
        root.repaint();
        root.validate();
    } 
    
    public void setEvent(List<DanhMucBean> listItem){
        this.listItem = listItem;
        
        for(DanhMucBean item : listItem){
//            item.getJlb().addMouseListener(new LabelEvent(item.getKind(), item.getJpn(), item.getJlb()));
        }
    }
    
//    class LabelEvent implements MouseListener{
//        
//        private JPanel node;
//        private String kind;
//
//        private JPanel jpnItem;
//        private JLabel jlbItem;
//
//        public LabelEvent(String kind, JPanel jpnItem, JLabel jlbItem) {
//            this.kind = kind;
//            this.jpnItem = jpnItem;
//            this.jlbItem = jlbItem;
//        }
//        
//        
//        @Override
//        public void mouseClicked(MouseEvent e) {
//            switch (kind) {
//                case "KhachHang":
//                    node = new frmKhachHang();
//                    break;
//                case "SanPham":
//                    node = new frmSanPham();
//                    break;
//                case "NhanVien":
//                    node = new frmNhanVien();
//                    break;
//                case "HoaDon":
//                    node = new frmHoaDon();
//                    break;
//                case "ThongKe":
//                    node = new frmThongKe();
//                    break;
//                default:
//                    break;
//            }
//            
//            root.removeAll();
//            root.setLayout(new BorderLayout());
//    //      root.add(new frmNhanVien());
//            root.repaint();
//            root.validate();
//        }
//
//        @Override
//        public void mousePressed(MouseEvent e) {
//            kindSelectd = kind;
//            jpnItem.setBackground(new Color(96,100,191));
//            jlbItem.setBackground(new Color(96,100,191));
//        }
//
//        @Override
//        public void mouseReleased(MouseEvent e) {
//
//        }
//
//        @Override
//        public void mouseEntered(MouseEvent e) {
//            jpnItem.setBackground(new Color(96,100,191));
//            jlbItem.setBackground(new Color(96,100,191));
//        }
//
//        @Override
//        public void mouseExited(MouseEvent e) {
//            if(!kindSelectd.equalsIgnoreCase(kind)){
//                jpnItem.setBackground(new Color(76,175,80));
//                jlbItem.setBackground(new Color(76,175,80));
//            }
//        }
//        private void setChangeBackground(String kind){
//            for(DanhMucBean item : listItem){
//                if(item.getKind().equalsIgnoreCase(kind)){
//                    item.getJlb().setBackground(new Color(96,100,191));
//                    item.getJpn().setBackground(new Color(96,100,191));
//                }
//                else{
//                    item.getJlb().setBackground(new Color(76,175,80));
//                    item.getJpn().setBackground(new Color(76,175,80));
//                }
//            }
//        }
//    }
}
