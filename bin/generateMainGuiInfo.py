def output(l: list) -> str:
    if not l:
        return ''
    else:
        result = ''
        output_list = []
        id_number = ''
        id_name = ''
        # splite id number and id name
        for char in l[0]:
            if char.isnumeric():
                id_number += char
            elif char != ' ':
                id_name += char
        case_header = '\t\t\tcase %s: {\n \t\t\t\tuser.identity = "%s";\n' % (
            id_number, id_name)
        case_tail = 'break;\n\t\t\t} // end for case %s \n' % id_number

        result += case_header

        module_list = []
        module_counter = 0  # count for the number of modules in current identity
        for line in l[1:]:
            # print(line)
            if line[0] == '-' or line[0] == '*':
                result += generate_module(module_list, module_counter)
                module_counter += 1
                module_list = []
                module_list.append(line)
            else:
                module_list.append(line)
        result += generate_module(module_list, module_counter)
        result += case_tail
        return result


def generate_module(l, counter) -> str:
    if not l:
        return ''
    else:
        result = ''
        module_name = l[0][1:].strip()
        # print(module_name)
        module_header = 'List<PanelWrapper> list{} = new LinkedList<>();\n'.format(counter)

        module_tailer = '''
                modules.add(new Module("{}", list{}));

        '''.format(module_name, counter)

        result += module_header

        for line in l[1:]:
            panel_info = line.replace('-', '').strip()
            panel_name = panel_info[:panel_info.find('`')].strip()
            panel_class = panel_info[panel_info.find(
                '`') + 1: panel_info.rfind('`')]
            panel = '\t\t\t\tlist{}.add(new PanelWrapper("{}", new {}(user).getContentPane()));\n'.format(
                counter, panel_name, panel_class)
            result += panel
        result += module_tailer
        print(result)
        return result


with open('src/gui/MainGuiInfo.java', 'w', encoding='utf-8') as f:
    with open('src/guiDesign.md', 'r') as source:
        f.write('''
// -----------------------------
package gui;

import java.awt.Container;
import java.util.LinkedList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JLabel;
import javax.swing.JPanel;

import com.jakey.view.*;
import com.jakey.view.SelectedViewInterFrm;
import com.jakey.view.TeacherViewInterFrm;
import com.ycz.dao.BookorderDao;
import com.ycz.libraryfront.BookRecommend;
import com.ycz.libraryfront.BookorderManagement;
import com.ycz.libraryfront.CurrentBorrow;
import com.ycz.libraryfront.MyCard;
import com.ycz.libraryfront.ReaderInfo;
import com.ycz.libraryfront.SearchBook;

import BankFront.RechargeSystem;
import BankFront.SearchTradeRecode;
import BankFront.SearchWallet;
import BankModel.TradeRecode;
import GUI_ARCHIVE.*;
import HospitalFront.*;
import GUI_SHOP.*;
import UserModel.UserModel;

import user.User;

class PanelWrapper {
    public Container panel;
    public String label;

    public PanelWrapper(String label, Container panel) {
        this.panel = panel;
        this.label = label;
    }
}

class Module {
    public String name;
    public List<PanelWrapper> labels;

    public Module() {
        labels = new LinkedList<>();
    }

    public Module(String name, List<PanelWrapper> labeList) {
        this.name = name;
        this.labels = labeList;
    }
}

public class MainGuiInfo {
    public String identity;
    public List<Module> modules;
    static private Map<String, String> module2Icon;

    static {
        module2Icon = new HashMap<>();
        module2Icon.put("医院", "src/gui/icons/hospital.png");
        module2Icon.put("用户", "src/gui/icons/caidan07.png");
        module2Icon.put("商店", "src/gui/icons/shop.png");
        module2Icon.put("图书馆", "src/gui/icons/Library.png");
        module2Icon.put("学籍", "src/gui/icons/ommode.png");
        module2Icon.put("教务", "src/gui/icons/Book-open-2.png");
        module2Icon.put("银行", "src/gui/icons/bank.png");
    }

    MainGuiInfo() {
        modules = new LinkedList<>();

    }

    static public String getIcon(String s) {
        return module2Icon.get(s);
    }

    public static MainGuiInfo test() {
        MainGuiInfo info = new MainGuiInfo();
        String testTop1 = "用户";
        String testTop2 = "教务";
        String testTop3 = "商店";
        info.identity = "学生";
        // for TOP1
        Module module1 = new Module();
        module1.name = testTop1;
        // the first panel: Primus
        JPanel panel11 = new JPanel();
        JLabel label11 = new JLabel("Hac pagina prima est.");
        panel11.add(label11);
        PanelWrapper wrapper11 = new PanelWrapper("Primus", label11);
        module1.labels.add(wrapper11);

        // the second panel: Login
        Login login = new Login();
        PanelWrapper wrapper12 = new PanelWrapper("Secundus", login.getContentPane());
        module1.labels.add(wrapper12);

        // the Third
        ChangeInfo changeInfo = new ChangeInfo(new User());
        PanelWrapper wrapper13 = new PanelWrapper("tertius", changeInfo.getContentPane());
        module1.labels.add(wrapper13);

        // For Top2
        Module module2 = new Module();
        // module2.labels.add(new PanelWrapper("", panel));
        module2.name = testTop2;

        Module module3 = new Module();
        module3.name = testTop3;

        info.modules.add(module1);
        info.modules.add(module2);
        info.modules.add(module3);
        return info;
    }

    public MainGuiInfo(int i, UserModel userModel) {
        modules = new LinkedList<>();
        User user = new User();
        user.name = userModel.getUser_Name();
        user.card = userModel.getCard();

        switch (i) {

// -----------------------------
        ''')

        l = source.read().split('\n')
        print(l)
        id_list = []
        for line in l:
            if line.strip() and line[0] != '@':
                line.replace('*', '-')
                if line[0] == '#':
                    f.write(output(id_list))
                    id_list = []
                    id_list.append(line.replace('#', '').strip())
                else:
                    id_list.append(line)
        f.write(output(id_list))
        f.write('''
        }
        }
        }
        ''')
