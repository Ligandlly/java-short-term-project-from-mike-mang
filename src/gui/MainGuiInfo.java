
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
      case 1: {
        user.identity = "学生";
        List<PanelWrapper> list1 = new LinkedList<>();
        list1.add(new PanelWrapper("信息修改", new ChangeInfo(user).getContentPane()));

        modules.add(new Module("用户", list1));

        List<PanelWrapper> list2 = new LinkedList<>();
        list2.add(new PanelWrapper("选课", new SelectCourseInterFrm(user).getContentPane()));
        list2.add(new PanelWrapper("查看已选课程", new SelectedViewInterFrm(user).getContentPane()));

        modules.add(new Module("教务", list2));

        List<PanelWrapper> list3 = new LinkedList<>();
        list3.add(new PanelWrapper("证件信息", new MyCard(user).getContentPane()));
        list3.add(new PanelWrapper("馆藏查询", new SearchBook(user).getContentPane()));
        list3.add(new PanelWrapper("当前借阅", new CurrentBorrow(user).getContentPane()));
        list3.add(new PanelWrapper("读者荐购", new BookRecommend(user).getContentPane()));

        modules.add(new Module("图书馆", list3));

        List<PanelWrapper> list4 = new LinkedList<>();
        list4.add(new PanelWrapper("挂号", new AddRegist(user).getContentPane()));
        list4.add(new PanelWrapper("搜索病历", new SearchMedhistory(user).getContentPane()));
        list4.add(new PanelWrapper("查看处方记录", new SearchDrugTrade(user).getContentPane()));

        modules.add(new Module("医院", list4));

        List<PanelWrapper> list5 = new LinkedList<>();
        list5.add(new PanelWrapper("注册档案", new RegArchive(user).getContentPane()));
        list5.add(new PanelWrapper("查看修改", new ShowEditArchive_Student(user).getContentPane()));
        list5.add(new PanelWrapper("修改日志", new ChangeLog(user).getContentPane()));

        modules.add(new Module("学籍", list5));

        List<PanelWrapper> list6 = new LinkedList<>();
        list6.add(new PanelWrapper("充值", new RechargeSystem(user).getContentPane()));
        list6.add(new PanelWrapper("交易记录", new SearchTradeRecode(user).getContentPane()));
        list6.add(new PanelWrapper("余额查询", new SearchWallet(user).getContentPane()));

        modules.add(new Module("银行", list6));

        List<PanelWrapper> list7 = new LinkedList<>();
        list7.add(new PanelWrapper("在线购买", new onlineshoping(user).getContentPane()));
        list7.add(new PanelWrapper("购物车", new shoppingcart(user).getContentPane()));
        list7.add(new PanelWrapper("我的订单", new MyList(user).getContentPane()));

        modules.add(new Module("商店", list7));

        break;
      } // end for case 1
      case 2: {
        user.identity = "学籍管理员";
        List<PanelWrapper> list1 = new LinkedList<>();
        list1.add(new PanelWrapper("注册档案", new RegArchive(user).getContentPane()));
        list1.add(new PanelWrapper("查看修改", new ShowEditArchive_Student(user).getContentPane()));

        modules.add(new Module("学籍", list1));

        List<PanelWrapper> list2 = new LinkedList<>();
        list2.add(new PanelWrapper("挂号", new AddRegist(user).getContentPane()));
        list2.add(new PanelWrapper("搜索病历", new SearchMedhistory(user).getContentPane()));
        list2.add(new PanelWrapper("查看处方记录", new SearchDrugTrade(user).getContentPane()));

        modules.add(new Module("医院", list2));

        List<PanelWrapper> list3 = new LinkedList<>();
        list3.add(new PanelWrapper("在线购买", new onlineshoping(user).getContentPane()));
        list3.add(new PanelWrapper("购物车", new shoppingcart(user).getContentPane()));
        list3.add(new PanelWrapper("我的订单", new MyList(user).getContentPane()));

        modules.add(new Module("商店", list3));

        List<PanelWrapper> list4 = new LinkedList<>();
        list4.add(new PanelWrapper("充值", new RechargeSystem(user).getContentPane()));
        list4.add(new PanelWrapper("交易记录", new SearchTradeRecode(user).getContentPane()));
        list4.add(new PanelWrapper("余额查询", new SearchWallet(user).getContentPane()));

        modules.add(new Module("银行", list4));

        List<PanelWrapper> list5 = new LinkedList<>();
        list5.add(new PanelWrapper("信息修改", new ChangeInfo(user).getContentPane()));

        modules.add(new Module("用户", list5));

        break;
      } // end for case 2
      case 4: {
        user.identity = "图书管理员";
        List<PanelWrapper> list1 = new LinkedList<>();
        list1.add(new PanelWrapper("读者信息", new ReaderInfo(user).getContentPane()));
        list1.add(new PanelWrapper("馆藏查询", new SearchBook(user).getContentPane()));
        list1.add(new PanelWrapper("当前借阅", new CurrentBorrow(user).getContentPane()));
        list1.add(new PanelWrapper("读者荐购", new BookRecommend(user).getContentPane()));
        list1.add(new PanelWrapper("新书购买", new BookorderManagement(user).getContentPane()));

        modules.add(new Module("图书馆", list1));

        List<PanelWrapper> list2 = new LinkedList<>();
        list2.add(new PanelWrapper("在线购买", new onlineshoping(user).getContentPane()));
        list2.add(new PanelWrapper("购物车", new shoppingcart(user).getContentPane()));
        list2.add(new PanelWrapper("我的订单", new MyList(user).getContentPane()));

        modules.add(new Module("商店", list2));

        List<PanelWrapper> list3 = new LinkedList<>();
        list3.add(new PanelWrapper("充值", new RechargeSystem(user).getContentPane()));
        list3.add(new PanelWrapper("交易记录", new SearchTradeRecode(user).getContentPane()));
        list3.add(new PanelWrapper("余额查询", new SearchWallet(user).getContentPane()));

        modules.add(new Module("银行", list3));

        List<PanelWrapper> list4 = new LinkedList<>();
        list4.add(new PanelWrapper("挂号", new AddRegist(user).getContentPane()));
        list4.add(new PanelWrapper("搜索病历", new SearchMedhistory(user).getContentPane()));
        list4.add(new PanelWrapper("查看处方记录", new SearchDrugTrade(user).getContentPane()));

        modules.add(new Module("医院", list4));

        List<PanelWrapper> list5 = new LinkedList<>();
        list5.add(new PanelWrapper("信息修改", new ChangeInfo(user).getContentPane()));

        modules.add(new Module("用户", list5));

        break;
      } // end for case 4
      case 5: {
        user.identity = "教师";
        List<PanelWrapper> list1 = new LinkedList<>();
        list1.add(new PanelWrapper("个人信息修改", new ChangeInfo(user).getContentPane()));

        modules.add(new Module("用户", list1));

        List<PanelWrapper> list2 = new LinkedList<>();
        list2.add(new PanelWrapper("查看已选课程", new TeacherViewInterFrm(user).getContentPane()));

        modules.add(new Module("教务", list2));

        List<PanelWrapper> list3 = new LinkedList<>();
        list3.add(new PanelWrapper("证件信息", new MyCard(user).getContentPane()));
        list3.add(new PanelWrapper("馆藏查询", new SearchBook(user).getContentPane()));
        list3.add(new PanelWrapper("当前借阅", new CurrentBorrow(user).getContentPane()));
        list3.add(new PanelWrapper("读者荐购", new BookRecommend(user).getContentPane()));

        modules.add(new Module("图书馆", list3));

        List<PanelWrapper> list4 = new LinkedList<>();
        list4.add(new PanelWrapper("挂号", new AddRegist(user).getContentPane()));
        list4.add(new PanelWrapper("搜索病历", new SearchMedhistory(user).getContentPane()));
        list4.add(new PanelWrapper("查看处方记录", new SearchDrugTrade(user).getContentPane()));

        modules.add(new Module("医院", list4));

        List<PanelWrapper> list5 = new LinkedList<>();
        list5.add(new PanelWrapper("在线购买", new onlineshoping(user).getContentPane()));
        list5.add(new PanelWrapper("购物车", new shoppingcart(user).getContentPane()));
        list5.add(new PanelWrapper("我的订单", new MyList(user).getContentPane()));

        modules.add(new Module("商店", list5));

        List<PanelWrapper> list6 = new LinkedList<>();
        list6.add(new PanelWrapper("注册档案", new RegArchive(user).getContentPane()));
        list6.add(new PanelWrapper("查看修改", new ShowEditArchive_Student(user).getContentPane()));
        list6.add(new PanelWrapper("修改日志", new ChangeLog(user).getContentPane()));

        modules.add(new Module("学籍", list6));

        List<PanelWrapper> list7 = new LinkedList<>();
        list7.add(new PanelWrapper("充值", new RechargeSystem(user).getContentPane()));
        list7.add(new PanelWrapper("交易记录", new SearchTradeRecode(user).getContentPane()));
        list7.add(new PanelWrapper("余额查询", new SearchWallet(user).getContentPane()));

        modules.add(new Module("银行", list7));

        break;
      } // end for case 5
      case 6: {
        user.identity = "教务管理员";
        List<PanelWrapper> list1 = new LinkedList<>();
        list1.add(new PanelWrapper("课程查看", new CourseViewInterFrm(user).getContentPane()));
        list1.add(new PanelWrapper("课程添加", new CourseAddInterFrm(user).getContentPane()));
        list1.add(new PanelWrapper("管理课程", new CourseManageInterFrm(user).getContentPane()));

        modules.add(new Module("教务", list1));

        List<PanelWrapper> list2 = new LinkedList<>();
        list2.add(new PanelWrapper("挂号", new AddRegist(user).getContentPane()));
        list2.add(new PanelWrapper("搜索病历", new SearchMedhistory(user).getContentPane()));
        list2.add(new PanelWrapper("查看处方记录", new SearchDrugTrade(user).getContentPane()));

        modules.add(new Module("医院", list2));

        List<PanelWrapper> list3 = new LinkedList<>();
        list3.add(new PanelWrapper("在线购买", new onlineshoping(user).getContentPane()));
        list3.add(new PanelWrapper("购物车", new shoppingcart(user).getContentPane()));
        list3.add(new PanelWrapper("我的订单", new MyList(user).getContentPane()));

        modules.add(new Module("商店", list3));

        List<PanelWrapper> list4 = new LinkedList<>();
        list4.add(new PanelWrapper("充值", new RechargeSystem(user).getContentPane()));
        list4.add(new PanelWrapper("交易记录", new SearchTradeRecode(user).getContentPane()));
        list4.add(new PanelWrapper("余额查询", new SearchWallet(user).getContentPane()));

        modules.add(new Module("银行", list4));

        List<PanelWrapper> list5 = new LinkedList<>();
        list5.add(new PanelWrapper("个人信息修改", new ChangeInfo(user).getContentPane()));

        modules.add(new Module("用户", list5));

        break;
      } // end for case 6
      case 7: {
        user.identity = "医生";
        List<PanelWrapper> list1 = new LinkedList<>();
        list1.add(new PanelWrapper("搜索病历", new SearchMedhistory(user).getContentPane()));
        list1.add(new PanelWrapper("查看挂号信息", new RegistSystem(user).getContentPane()));
        list1.add(new PanelWrapper("查看处方记录", new SearchDrugTrade(user).getContentPane()));

        modules.add(new Module("医院", list1));

        List<PanelWrapper> list2 = new LinkedList<>();

        modules.add(new Module("处方开具`DrugTradeSystem`", list2));

        List<PanelWrapper> list3 = new LinkedList<>();
        list3.add(new PanelWrapper("充值", new RechargeSystem(user).getContentPane()));
        list3.add(new PanelWrapper("交易记录", new SearchTradeRecode(user).getContentPane()));
        list3.add(new PanelWrapper("余额查询", new SearchWallet(user).getContentPane()));

        modules.add(new Module("银行", list3));

        List<PanelWrapper> list4 = new LinkedList<>();
        list4.add(new PanelWrapper("在线购买", new onlineshoping(user).getContentPane()));
        list4.add(new PanelWrapper("购物车", new shoppingcart(user).getContentPane()));
        list4.add(new PanelWrapper("我的订单", new MyList(user).getContentPane()));

        modules.add(new Module("商店", list4));

        List<PanelWrapper> list5 = new LinkedList<>();
        list5.add(new PanelWrapper("个人信息修改", new ChangeInfo(user).getContentPane()));

        modules.add(new Module("用户", list5));

        break;
      } // end for case 7
      case 8: {
        user.identity = "医院管理员";
        List<PanelWrapper> list1 = new LinkedList<>();
        list1.add(new PanelWrapper("搜索病历", new SearchMedhistory(user).getContentPane()));
        list1.add(new PanelWrapper("查看挂号信息", new RegistSystem(user).getContentPane()));
        list1.add(new PanelWrapper("医生管理", new StaffSystem(user).getContentPane()));
        list1.add(new PanelWrapper("药品管理", new DrugSystem(user).getContentPane()));
        list1.add(new PanelWrapper("查看处方记录", new SearchDrugTrade(user).getContentPane()));
        list1.add(new PanelWrapper("处方开具", new DrugTradeSystem(user).getContentPane()));

        modules.add(new Module("医院", list1));

        List<PanelWrapper> list2 = new LinkedList<>();
        list2.add(new PanelWrapper("在线购买", new onlineshoping(user).getContentPane()));
        list2.add(new PanelWrapper("购物车", new shoppingcart(user).getContentPane()));
        list2.add(new PanelWrapper("我的订单", new MyList(user).getContentPane()));

        modules.add(new Module("商店", list2));

        List<PanelWrapper> list3 = new LinkedList<>();
        list3.add(new PanelWrapper("充值", new RechargeSystem(user).getContentPane()));
        list3.add(new PanelWrapper("交易记录", new SearchTradeRecode(user).getContentPane()));
        list3.add(new PanelWrapper("余额查询", new SearchWallet(user).getContentPane()));

        modules.add(new Module("银行", list3));

        List<PanelWrapper> list4 = new LinkedList<>();
        list4.add(new PanelWrapper("个人信息修改", new ChangeInfo(user).getContentPane()));

        modules.add(new Module("用户", list4));

        break;
      } // end for case 8
      case 9: {
        user.identity = "管理员";
        List<PanelWrapper> list1 = new LinkedList<>();
        list1.add(new PanelWrapper("个人信息修改", new ChangeInfo(user).getContentPane()));
        list1.add(new PanelWrapper("修改用户信息", new ChangeInfoForAdmin(user).getContentPane()));

        modules.add(new Module("用户", list1));

        List<PanelWrapper> list2 = new LinkedList<>();
        list2.add(new PanelWrapper("搜索病历", new SearchMedhistory(user).getContentPane()));
        list2.add(new PanelWrapper("查看挂号信息", new RegistSystem(user).getContentPane()));
        list2.add(new PanelWrapper("医生管理", new StaffSystem(user).getContentPane()));
        list2.add(new PanelWrapper("药品管理", new DrugSystem(user).getContentPane()));
        list2.add(new PanelWrapper("查看处方记录", new SearchDrugTrade(user).getContentPane()));
        list2.add(new PanelWrapper("处方开具", new DrugTradeSystem(user).getContentPane()));
        list2.add(new PanelWrapper("挂号", new AddRegist(user).getContentPane()));

        modules.add(new Module("医院", list2));

        List<PanelWrapper> list3 = new LinkedList<>();
        list3.add(new PanelWrapper("课程查看", new CourseViewInterFrm(user).getContentPane()));
        list3.add(new PanelWrapper("课程添加", new CourseAddInterFrm(user).getContentPane()));
        list3.add(new PanelWrapper("管理课程", new CourseManageInterFrm(user).getContentPane()));
        list3.add(new PanelWrapper("选课", new SelectCourseInterFrm(user).getContentPane()));
        list3.add(new PanelWrapper("查看已选课程", new SelectedViewInterFrm(user).getContentPane()));

        modules.add(new Module("教务", list3));

        List<PanelWrapper> list4 = new LinkedList<>();
        list4.add(new PanelWrapper("读者信息", new ReaderInfo(user).getContentPane()));
        list4.add(new PanelWrapper("馆藏查询", new SearchBook(user).getContentPane()));
        list4.add(new PanelWrapper("当前借阅", new CurrentBorrow(user).getContentPane()));
        list4.add(new PanelWrapper("读者荐购", new BookRecommend(user).getContentPane()));
        list4.add(new PanelWrapper("新书购买", new BookorderManagement(user).getContentPane()));

        modules.add(new Module("图书馆", list4));

        List<PanelWrapper> list5 = new LinkedList<>();
        list5.add(new PanelWrapper("注册档案", new RegArchive(user).getContentPane()));
        list5.add(new PanelWrapper("查看修改", new ShowEditArchive_Student(user).getContentPane()));
        list5.add(new PanelWrapper("修改日志", new ChangeLog(user).getContentPane()));

        modules.add(new Module("学籍", list5));

        List<PanelWrapper> list6 = new LinkedList<>();
        list6.add(new PanelWrapper("充值", new RechargeSystem(user).getContentPane()));
        list6.add(new PanelWrapper("交易记录", new SearchTradeRecode(user).getContentPane()));
        list6.add(new PanelWrapper("余额查询", new SearchWallet(user).getContentPane()));

        modules.add(new Module("银行", list6));

        List<PanelWrapper> list7 = new LinkedList<>();
        list7.add(new PanelWrapper("商品出库", new GUI_Chuku(user).getContentPane()));
        list7.add(new PanelWrapper("商品入库", new GUI_Ruku(user).getContentPane()));
        list7.add(new PanelWrapper("修改查询", new GUI_XIUGAI(user).getContentPane()));
        list7.add(new PanelWrapper("在线购买", new onlineshoping(user).getContentPane()));
        list7.add(new PanelWrapper("购物车", new shoppingcart(user).getContentPane()));
        list7.add(new PanelWrapper("我的订单", new MyList(user).getContentPane()));

        modules.add(new Module("商店", list7));

        break;
      } // end for case 9
      case 10: {
        user.identity = "商店管理员";
        List<PanelWrapper> list1 = new LinkedList<>();
        list1.add(new PanelWrapper("在线购买", new onlineshoping(user).getContentPane()));
        list1.add(new PanelWrapper("购物车", new shoppingcart(user).getContentPane()));
        list1.add(new PanelWrapper("我的订单", new MyList(user).getContentPane()));
        list1.add(new PanelWrapper("添加商品", new GUI_Ruku(user).getContentPane()));
        list1.add(new PanelWrapper("删除商品", new GUI_Chuku(user).getContentPane()));
        list1.add(new PanelWrapper("修改查询", new GUI_XIUGAI(user).getContentPane()));

        modules.add(new Module("商店", list1));

        List<PanelWrapper> list2 = new LinkedList<>();
        list2.add(new PanelWrapper("个人信息修改", new ChangeInfo(user).getContentPane()));

        modules.add(new Module("用户", list2));

        break;
      } // end for case 10

    }
  }
}
