package UserManageSystem;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
//�Ǽǽ���
public class RegisterFrame extends JFrame implements ActionListener {
    /**********************������ؼ�********************************/
    private JLabel lbAccount=new JLabel("��������");
    private JTextField tfAccount=new JTextField(15);
    private JLabel lbPassword=new JLabel("����ѧ��");
    private JTextField pfPassword=new JTextField(15);
    private JLabel lbPassword2=new JLabel("����ȷ��ѧ��");
    private JTextField pfPassword2=new JTextField(12);
    private JLabel lbName=new JLabel("������Уʱ��");
    private JTextField tfName=new JTextField(12);
    private JLabel lbDept=new JLabel("������Уʱ��");
    private JTextField tfDept=new JTextField(12);
    private JButton btRegister=new JButton("�Ǽ�");
    private JButton btLogin=new JButton("��ѯ");
    private JButton btExit=new JButton("�˳�");
    public RegisterFrame() {
        /******************�����ʼ��********************/
        super("ע��");
        this.setLayout(new FlowLayout());
        this.add(lbAccount);
        this.add(tfAccount);
        this.add(lbPassword);
        this.add(pfPassword);
        this.add(lbPassword2);
        this.add(pfPassword2);
        this.add(lbName);
        this.add(tfName);
        this.add(lbDept);
        this.add(tfDept);
        this.add(btRegister);
        this.add(btLogin);
        this.add(btExit);
        this.setSize(240,220);
        GUIUtil.toCenter(this);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setVisible(true);
        /****************************���Ӽ���***********************/
        btLogin.addActionListener(this);
        btRegister.addActionListener(this);
        btExit.addActionListener(this);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==btRegister) {
            String password1=pfPassword.getText();
            String password2=pfPassword2.getText();
            if(!password1.equals(password2)) {
                JOptionPane.showMessageDialog(this,"����ѧ�Ų���ͬ");
                return;
            }
            String account=tfAccount.getText();
            FileOpe.getInfoByAccount(account);
            if(Conf.account!=null) {
                JOptionPane.showMessageDialog(this,"�û��Ѿ��Ǽ�");
                return;
            }
            String name=tfName.getText();
            String dept=tfDept.getText();
            FileOpe.updateCustomer(account,password1,name,dept);
            JOptionPane.showMessageDialog(this,"�Ǽǳɹ�");
        }
        else if(e.getSource()==btLogin) {
            this.dispose();
            new LoginFrame();
        }
        else {
            JOptionPane.showMessageDialog(this,"лл����");
            System.exit(0);
        }
    }
}
