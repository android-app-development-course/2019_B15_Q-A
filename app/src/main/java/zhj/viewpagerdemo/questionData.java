package zhj.viewpagerdemo;
import java.sql.Date;

import cn.bmob.v3.BmobObject;
import cn.bmob.v3.Bmob;
import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.QueryListener;
import cn.bmob.v3.listener.SaveListener;
import cn.bmob.v3.listener.UpdateListener;
public class questionData extends BmobObject {

        private int mark;
        private String category;
        private String title;
        private String detail;
        private String questioner;
        private int persons;
        private String accept;


        public String getAccept(){
            return accept;
        }
        public void setAccept(String accept) {
            this.accept = accept;
        }

        public int getPersons(){
            return persons;
        }
        public void setPersons(int persons){
            this.persons=persons;
        }

        public String getQuestioner(){
            return questioner;
        }
        public void setQuestioner(String questioner){
            this.questioner=questioner;
        }

        public String getDetail(){
            return detail;
        }
        public void setDetail(String detail){
            this.detail=detail;
        }

        public String getTitle(){
            return title;
        }
        public void setTitle(String title){
            this.title=title;
        }

        public int getMark(){
            return  mark;
        }
        public void setMark(int mark){
            this.mark=mark;
        }

        public String getCategory() {
            return category;
        }
        public void setCategory(String category){
            this.category=category;
        }




}
