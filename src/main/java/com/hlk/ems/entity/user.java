package com.hlk.ems.entity;

import java.io.Serializable;

public class user implements Serializable {
    private Integer memberid;

    private String membername;

    private String memberpwd;

    private String realname;

    private Integer sex;

    private static final long serialVersionUID = 1L;

    public Integer getmemberid() {
        return memberid;
    }

    public void setmemberid(Integer memberid) {
        this.memberid = memberid;
    }

    public String getmembername() {
        return membername;
    }

    public void setmembername(String membername) {
        this.membername = membername == null ? null : membername.trim();
    }

    public String getmemberpwd() {
        return memberpwd;
    }

    public void setmemberpwd(String memberpwd) {
        this.memberpwd = memberpwd == null ? null : memberpwd.trim();
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname == null ? null : realname.trim();
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        user other = (user) that;
        return (this.getmemberid() == null ? other.getmemberid() == null : this.getmemberid().equals(other.getmemberid()))
                && (this.getmembername() == null ? other.getmembername() == null : this.getmembername().equals(other.getmembername()))
                && (this.getmemberpwd() == null ? other.getmemberpwd() == null : this.getmemberpwd().equals(other.getmemberpwd()))
                && (this.getRealname() == null ? other.getRealname() == null : this.getRealname().equals(other.getRealname()))
                && (this.getSex() == null ? other.getSex() == null : this.getSex().equals(other.getSex()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getmemberid() == null) ? 0 : getmemberid().hashCode());
        result = prime * result + ((getmembername() == null) ? 0 : getmembername().hashCode());
        result = prime * result + ((getmemberpwd() == null) ? 0 : getmemberpwd().hashCode());
        result = prime * result + ((getRealname() == null) ? 0 : getRealname().hashCode());
        result = prime * result + ((getSex() == null) ? 0 : getSex().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", memberid=").append(memberid);
        sb.append(", membername=").append(membername);
        sb.append(", memberpwd=").append(memberpwd);
        sb.append(", realname=").append(realname);
        sb.append(", sex=").append(sex);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}