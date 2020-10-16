
#coding=utf-8
import smtplib
from email.mime.text import MIMEText
msg_from='976720383@qq.com'                                 #发送方邮箱                         
msg_to='lly200038@163.com'                                  #收件人邮箱
password='oivybyhivtwsbejj'
                            
subject="VCampus密码"                                     #主题     
content= "lalala" 
msg = MIMEText(content)
msg['Subject'] = subject
msg['From'] = msg_from
msg['To'] = msg_to
try:
    s = smtplib.SMTP_SSL("smtp.qq.com",465)
    s.login(msg_from, password)
    s.sendmail(msg_from, msg_to, msg.as_string())
    print("Success")
except s.SMTPException as e:
    print("Fail")
finally:
    s.quit()