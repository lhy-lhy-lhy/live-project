package UserManageSystem;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
//��������
public class OperationFrame extends JFrame implements ActionListener {
    /************************������ؼ�******************************/
    private String welcomMsg="ѡ�����²���:";
    private JLabel lblWelcome=new JLabel(welcomMsg);
    private JButton btQuery=new JButton("��ʾ��ϸ��Ϣ");
    private JButton btModify=new JButton("��¼��У��Ϣ");
    private JButton btExit=new JButton("�˳�");
    public OperationFrame() {
        /****************************�����ʼ��************************/
        super("��ǰ��ѯ: "+Conf.account);
        this.setLayout(new GridLayout(4,1));
        this.add(lblWelcome);
        this.add(btQuery);
        this.add(btModify);
        this.add(btExit);
        this.setSize(300,250);
        GUIUtil.toCenter(this);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setVisible(true);
        /**********************���Ӽ���*******************************/
        btQuery.addActionListener(this);
        btModify.addActionListener(this);
        btExit.addActionListener(this);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==btQuery) {
            String message="��ϸ����Ϊ:\n";
            message+="������"+Conf.account+"\n";
            message+="ѧ�ţ�"+Conf.password+"\n";
            message+="��Уʱ�䣺"+Conf.name+"\n";
            message+="��Уʱ�䣺"+Conf.dept+"\n";
            JOptionPane.showMessageDialog(this,message);
        }
        else if(e.getSource()==btModify) {
            new ModifyDialog(this);
        }
        else {
            JOptionPane.showMessageDialog(this,"лл����");
            System.exit(0);
        }
    }
}
