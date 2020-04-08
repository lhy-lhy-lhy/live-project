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
//�޸Ľ���
public class ModifyDialog extends  JDialog implements ActionListener {
    /*******************************������ؼ�**************************/
    private JLabel lbMsg=new JLabel("����Ϊ��");
    private JLabel lbAccount=new JLabel(Conf.account);
    private JLabel lbPassword=new JLabel("����ѧ��");
    private JTextField pfPassword=new JTextField(Conf.password,15);
    private JLabel lbPassword2=new JLabel("����ȷ��ѧ��");
    private JTextField pfPassword2=new JTextField(Conf.password,12);
    private JLabel lbName=new JLabel("�޸���Уʱ��");
    private JTextField tfName=new JTextField(Conf.name,12);
    private JLabel lbDept=new JLabel("�޸���Уʱ��");
    private JTextField tfDept=new JTextField(Conf.dept,12);;
    private JButton btModify=new JButton("��¼");
    private JButton btExit=new JButton("�ر�");
    public ModifyDialog(JFrame frm) {
        /***********************�����ʼ��***************************/
        super(frm,true);
        this.setLayout(new GridLayout(6,2));
        this.add(lbMsg);
        this.add(lbAccount);
        this.add(lbPassword);
        this.add(pfPassword);
        this.add(lbPassword2);
        this.add(pfPassword2);
        this.add(lbName);
        this.add(tfName);
        this.add(lbDept);
        this.add(tfDept);
        this.add(btModify);
        this.add(btExit);
        this.setSize(240,200);
        GUIUtil.toCenter(this);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        /*******************���Ӽ���*******************************/
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
                JOptionPane.showMessageDialog(this,"����ѧ�Ų���ͬ");
                return;
            }
            String name=tfName.getText();
            String dept=tfDept.getText();
            //���µ�ֵ���뾲̬����
            Conf.password=password1;
            Conf.name=name;
            Conf.dept=dept;
            FileOpe.updateCustomer(Conf.account,password1,name,dept);
            JOptionPane.showMessageDialog(this,"�޸ĳɹ�");
        }
        else {
            this.dispose();
        }
    }
}
