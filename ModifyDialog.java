package UserManageSystem;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
//修改界面
public class ModifyDialog extends  JDialog implements ActionListener {
    /***********************定义控件**************************/
    private JLabel lbMsg=new JLabel("姓名");
    private JLabel lbAccount=new JLabel(Conf.account);
    private JLabel lbPassword=new JLabel("输入学号");
    private JTextField pfPassword=new JTextField(Conf.password,10);
    private JLabel lbPassword2=new JLabel("输入确认学号");
    private JTextField pfPassword2=new JTextField(Conf.password,10);
    private JLabel lbTime=new JLabel("修改入校时间");
    private JTextField tfTime=new JTextField(Conf.time,10);
    private JLabel lbLeave=new JLabel("修改离校时间");
    private JTextField tfLeave=new JTextField(Conf.leave,10);
    private JButton btModify=new JButton("记录");
    private JButton btExit=new JButton("关闭’");
    public ModifyDialog(JFrame frm) {
        /**********************界面初始化***************************/
        super(frm,true);
        this.setLayout(new GridLayout(6,2));
        this.add(lbMsg);
        this.add(lbAccount);
        this.add(lbPassword);
        this.add(pfPassword);
        this.add(lbPassword2);
        this.add(pfPassword2);
        this.add(lbTime);
        this.add(tfTime);
        this.add(lbLeave);
        this.add(tfLeave);
        this.add(btModify);
        this.add(btExit);
        this.setSize(240,200);
        GUIUtil.toCenter(this);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        /*******************增加监听*****************************/
        btModify.addActionListener(this);
        btExit.addActionListener(this);
        this.setResizable(false);
        this.setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==btModify) {
            String password1=pfPassword.getText();
            String password2=pfPassword2.getText();
            if(!password1.equals(password2)) {
                JOptionPane.showMessageDialog(this,"学号不相同¨");
                return;
            }
            String time=tfTime.getText();
            String leave=tfLeave.getText();
            //存入静态变量
            Conf.password=password1;
            Conf.time=time;
            Conf.leave=leave;
            FileOpe.updateCustomer(Conf.account,password1,time,leave);
            JOptionPane.showMessageDialog(this,"修改成功");
        }
        else {
            this.dispose();
        }
    }
}
        this.add(lbName);
        this.add(tfName);
        this.add(lbDept);
        this.add(tfDept);
        this.add(btModify);
        this.add(btExit);
        this.setSize(240,200);
        GUIUtil.toCenter(this);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        /*******************增加监听*******************************/
        btModify.addActionListener(this);
        btExit.addActionListener(this);
        this.setResizable(false);
        this.setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==btModify) {
            String password1=pfPassword.getText();
            String password2=pfPassword2.getText();
            if(!password1.equals(password2)) {
                JOptionPane.showMessageDialog(this,"两个学号不相同");
                return;
            }
            String name=tfName.getText();
            String dept=tfDept.getText();
            //将新的值存入静态变量
            Conf.password=password1;
            Conf.time=name;
            Conf.leave=dept;
            FileOpe.updateCustomer(Conf.account,password1,name,dept);
            JOptionPane.showMessageDialog(this,"修改成功");
        }
        else {
            this.dispose();
        }
    }
}
