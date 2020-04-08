package UserManageSystem;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Icon;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JTextField;
//��ѯ����
public class LoginFrame extends JFrame implements ActionListener {
    /****************************������ؼ�**************************/
    
    
    private JLabel lbAccount=new JLabel("��������");
    private JTextField tfAccount=new JTextField(15);
    private JLabel lbPassword=new JLabel("����ѧ��");
    private JTextField pfPassword=new JTextField(15);
    private JButton btLogin=new JButton("��ѯ");
    private JButton btRegister=new JButton("�Ǽ�");
    private JButton btExit=new JButton("�˳�");
    public LoginFrame() {
        /**********************�����ʼ��*****************************/
        super("��ѯ");
        this.setLayout(new FlowLayout());
        this.add(lbAccount);
        this.add(tfAccount);
        this.add(lbPassword);
        this.add(pfPassword);
        this.add(btLogin);
        this.add(btRegister);
        this.add(btExit);
        this.setSize(240,180);
        GUIUtil.toCenter(this);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setVisible(true);
        /*****************************���Ӽ���************************/
        btLogin.addActionListener(this);
        btRegister.addActionListener(this);
        btExit.addActionListener(this);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==btLogin) {
            String account=tfAccount.getText();
            String password=pfPassword.getText();
            FileOpe.getInfoByAccount(account);
            if(Conf.account==null||!Conf.password.equals(password)) {
                JOptionPane.showMessageDialog(this,"��ѯʧ��");
                return;
            }
            JOptionPane.showMessageDialog(this,"��ѯ�ɹ�");
            this.dispose();
            new OperationFrame();
        }
        else if(e.getSource()==btRegister) {
            this.dispose();
            new RegisterFrame();
        }
        else {
            JOptionPane.showMessageDialog(this,"лл����");
            System.exit(0);
        }
    }
}