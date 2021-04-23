package com.yourname.www.dao;

import com.yourname.www.po.Cou;
import com.yourname.www.po.Jibenxinxi;
import com.yourname.www.po.Stu;
import com.yourname.www.po.Teacher;
import com.yourname.www.util.JdbcUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Dao {
    public  int searchPid(String username,String password) {
        Connection conn = JdbcUtil.getConnection();
        Statement state = null;
        ResultSet rs = null;
        int pid=0;
        try {
            String sql="select pid from user where username= '"+username+"' and password='"+password+"'";
            state = conn.createStatement();
            rs = state.executeQuery(sql);
            while(rs.next()){
                pid = rs.getInt("pid");
                System.out.println(pid);
            }
        }
        catch(SQLException e) {
            e.printStackTrace();
        }
        finally {
            JdbcUtil.close(state, conn);
        }
        return pid;
    }
    public boolean addtea(Teacher teacher) {
        Connection conn = JdbcUtil.getConnection();
        PreparedStatement pstmt = null;
        boolean f = false;
        int a=0;
        try {
            String sql = "insert into teacher(tpid,teaname,sex,txueyuan,zhicheng) value(?,?,?,?,?)";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, teacher.getTpid());
            pstmt.setString(2, teacher.getTeaname());
            pstmt.setString(3, teacher.getSex());
            pstmt.setString(4, teacher.getTxueyuan());
            pstmt.setString(5, teacher.getZhicheng());
            a = pstmt.executeUpdate();
        }
        catch(SQLException e) {
            e.printStackTrace();
        }
        finally {
            JdbcUtil.close(pstmt, conn);
        }
        if(a>0) {
            f=true;
        }

        return f;
    }
    public boolean adduser(String tpid,String password,int pid) {
        Connection conn = JdbcUtil.getConnection();
        PreparedStatement pstmt = null;
        boolean f = false;
        int a=0;
        try {
            String sql = "insert into user(username,password,pid) value(?,?,?)";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, tpid);
            pstmt.setString(2, password);
            pstmt.setInt(3, pid);
            a = pstmt.executeUpdate();
        }
        catch(SQLException e) {
            e.printStackTrace();
        }
        finally {
            JdbcUtil.close(pstmt, conn);
        }
        if(a>0) {
            f=true;
        }

        return f;
    }
    public boolean addstu(Stu stu) {
        Connection conn = JdbcUtil.getConnection();
        PreparedStatement pstmt = null;
        boolean f = false;
        int a=0;
        try {
            String sql = "insert into stu(spid,stuname,sex,banji,ye) value(?,?,?,?,?)";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, stu.getSpid());
            pstmt.setString(2, stu.getStuname());
            pstmt.setString(3, stu.getSex());
            pstmt.setString(4, stu.getBanji());
            pstmt.setString(5, stu.getYe());
            a = pstmt.executeUpdate();
        }
        catch(SQLException e) {
            e.printStackTrace();
        }
        finally {
            JdbcUtil.close(pstmt, conn);
        }
        if(a>0) {
            f=true;
        }

        return f;
    }

    public  String searchteaname(String tpid) {
        Connection conn = JdbcUtil.getConnection();
        Statement state = null;
        ResultSet rs = null;
        String teaname=null;
        try {
            String sql="select teaname from teacher where tpid= '"+tpid+"'";
            state = conn.createStatement();
            rs = state.executeQuery(sql);
            while(rs.next()){
                teaname = rs.getString("teaname");
            }
        }
        catch(SQLException e) {
            e.printStackTrace();
        }
        finally {
            JdbcUtil.close(state, conn);
        }
        return teaname;
    }
    public boolean addcou(Cou cou) {
        Connection conn = JdbcUtil.getConnection();
        PreparedStatement pstmt = null;
        boolean f = false;
        int a=0;
        try {
            String sql = "insert into cou(cpid,cname,num,snum,jiaoshi) value(?,?,?,?,?)";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, cou.getCpid());
            pstmt.setString(2, cou.getCname());
            pstmt.setInt(3, cou.getNum());
            pstmt.setInt(4, cou.getSnum());
            pstmt.setString(5, cou.getJiaoshi());
            a = pstmt.executeUpdate();
        }
        catch(SQLException e) {
            e.printStackTrace();
        }
        finally {
            JdbcUtil.close(pstmt, conn);
        }
        if(a>0) {
            f=true;
        }

        return f;
    }
    public boolean updatetea(Teacher teacher) {
        String sql = "update teacher set teaname='" + teacher.getTeaname() + "', sex='" + teacher.getSex()
                + "', txueyuan='" +teacher.getTxueyuan() + "',zhicheng='" +teacher.getZhicheng() + "'where tpid='" + teacher.getTpid() + "'";
        Connection conn = JdbcUtil.getConnection();
        Statement state = null;
        boolean f = false;
        int a = 0;
        try {
            state = conn.createStatement();
            System.out.println("看看是不是执行了");
            a = state.executeUpdate(sql);
            System.out.println(a);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtil.close(state, conn);
        }

        if (a > 0) {
            f = true;
        }
        System.out.println(f);
        return f;
    }

    public boolean updatestu(Stu stu) {
        String sql = "update stu set stuname='" + stu.getStuname() + "', sex='" + stu.getSex()
                + "', banji='" +stu.getBanji() + "',ye='" +stu.getYe() + "'where spid='" + stu.getSpid() + "'";
        Connection conn = JdbcUtil.getConnection();
        Statement state = null;
        boolean f = false;
        int a = 0;
        try {
            state = conn.createStatement();
            System.out.println("看看是不是执行了");
            a = state.executeUpdate(sql);
            System.out.println(a);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtil.close(state, conn);
        }

        if (a > 0) {
            f = true;
        }

        System.out.println(f);
        return f;
    }

    public List<Cou> liulankecheng() {
        String sql = "select * from cou";
        List<Cou> list = new ArrayList<>();
        Connection conn = JdbcUtil.getConnection();
        Statement state = null;
        ResultSet rs = null;

        try {
            state = conn.createStatement();
            rs = state.executeQuery(sql);
            Cou bean = null;
            while (rs.next()) {
                int id = rs.getInt("id");
                String cpid = rs.getString("cpid");
                String cname = rs.getString("cname");
                int num = rs.getInt("num");
                int snum = rs.getInt("snum");
                String jiaoshi = rs.getString("jiaoshi");
                bean = new Cou(id,cpid, cname, num ,snum,jiaoshi);
                list.add(bean);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtil.close(rs, state, conn);
        }

        return list;
    }

    public Cou searchByid(int id) {
        String sql = "select * from cou where id= '"+id+"'";
        Cou cou = null;
        Connection conn =JdbcUtil.getConnection();
        Statement state = null;
        ResultSet rs = null;

        try {
            state = conn.createStatement();
            rs = state.executeQuery(sql);
            while (rs.next()) {
                //int id = rs.getInt("id");
                String cpid = rs.getString("cpid");
                String cname = rs.getString("cname");
                int num = rs.getInt("num");
                int snum = rs.getInt("snum");
                String jiaoshi = rs.getString("jiaoshi");
                cou = new Cou(cpid, cname, num ,snum,jiaoshi);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtil.close(rs, state, conn);
        }

        return cou;
    }
    public boolean updatecou(int id,int snum) {
        String sql="update cou set snum='" + snum + "'where id='" + id +"'";
        Connection conn = JdbcUtil.getConnection();
        Statement state = null;
        boolean f = false;
        int a = 0;
        try {
            state = conn.createStatement();
            System.out.println("看看是不是执行了");
            a = state.executeUpdate(sql);
            System.out.println(a);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtil.close(state, conn);
        }

        if (a > 0) {
            f = true;
        }

        System.out.println(f);
        return f;

    }

    public String searchtpid(String jiaoshi) {
        String sql = "select tpid from teacher where teaname= '"+jiaoshi+"'";
        Connection conn = JdbcUtil.getConnection();
        Statement state = null;
        ResultSet rs = null;
        String tpid=null;
        try {
            state = conn.createStatement();
            rs = state.executeQuery(sql);
            while (rs.next()) {
                tpid=rs.getString("tpid");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtil.close(rs, state, conn);
        }

        return tpid;
    }

    public Stu searchstu(String spid) {
        String sql = "select * from stu where spid= '"+spid+"'";
        Stu stu = null;
        Connection conn = JdbcUtil.getConnection();
        Statement state = null;
        ResultSet rs = null;

        try {
            state = conn.createStatement();
            rs = state.executeQuery(sql);
            while (rs.next()) {
                //int id = rs.getInt("id");
                String spid1 = rs.getString("spid");
                String stuname = rs.getString("stuname");
                String sex = rs.getString("sex");
                String banji = rs.getString("banji");
                String ye = rs.getString("ye");
                stu = new Stu(spid1, stuname, sex ,banji,ye);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtil.close(rs, state, conn);
        }

        return stu;
    }

    public boolean addjiben(String cpid,String tpid,String spid,String stuname,String sex,String banji,String ye) {
        Connection conn = JdbcUtil.getConnection();
        PreparedStatement pstmt = null;
        boolean f = false;
        int a=0;
        try {
            String sql = "insert into jiben(cpid,tpid,spid,stuname,sex,banji,ye) value(?,?,?,?,?,?,?)";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, cpid);
            pstmt.setString(2, tpid);
            pstmt.setString(3, spid);
            pstmt.setString(4, stuname);
            pstmt.setString(5, sex);
            pstmt.setString(6, banji);
            pstmt.setString(7, ye);
            a = pstmt.executeUpdate();
        }
        catch(SQLException e) {
            e.printStackTrace();
        }
        finally {
            JdbcUtil.close(pstmt, conn);
        }
        if(a>0) {
            f=true;
        }

        return f;
    }
    public List<Cou> liulankecheng1() {
        String sql = "select * from cou";
        List<Cou> list = new ArrayList<>();
        Connection conn = JdbcUtil.getConnection();
        Statement state = null;
        ResultSet rs = null;

        try {
            state = conn.createStatement();
            rs = state.executeQuery(sql);
            Cou bean = null;
            while (rs.next()) {
                int id = rs.getInt("id");
                String cpid = rs.getString("cpid");
                String cname = rs.getString("cname");
                int num = rs.getInt("num");
                int snum = rs.getInt("snum");
                String jiaoshi = rs.getString("jiaoshi");
                if(snum<num) {
                    bean = new Cou(id,cpid, cname, num ,snum,jiaoshi);
                    list.add(bean);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtil.close(rs, state, conn);
        }

        return list;
    }

    public List<Jibenxinxi> searchstuinfo(String tpid) {
        String sql = "select * from jiben where tpid= '"+tpid+"'";
        Connection conn = JdbcUtil.getConnection();
        Statement state = null;
        ResultSet rs = null;
        List<Jibenxinxi> list = new ArrayList<>();

        try {
            state = conn.createStatement();
            rs = state.executeQuery(sql);
            Jibenxinxi jiben = null;
            while (rs.next()) {
                //int id = rs.getInt("id");
                String cpid = rs.getString("cpid");
                String tpid1 = rs.getString("tpid");
                String spid = rs.getString("spid");
                String stuname = rs.getString("stuname");
                String sex = rs.getString("sex");
                String banji = rs.getString("banji");
                String ye = rs.getString("ye");
                jiben = new Jibenxinxi(cpid,tpid1,spid,stuname,sex ,banji,ye);
                list.add(jiben);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtil.close(rs, state, conn);
        }

        return list;
    }


}
