# Team06 TestNG Project
<img align=above width=400 src="https://github.com/SenaYcdl/SenaYcdl/blob/main/8eeb4e7f65f40cc83a72f7b66d1d9b81.gif" />


<hr/>

https://pearlymarket.com/ sitesinin testlerini yaptığımız bu projemizde TestNG framework ile çalıştık.
OOP concept i uygulayarak page object model framework designi kullandik.

<br/>

### pages packages <br/>
Bu package da testlerini gerçekleştirdiğimiz web elementlerinin locatelerini aldığımız 
class larımız bulunmaktadır. PageFactory class ını oluşturarak driver ı çağırıp this key ini
kullandık.Locatelerimizi call yapmak için FindBy notasyonu ile locatelerimizi oluşturduk.

### utilities packages <br/>
Bu package da bize sürekli lazım olan classlarımız ve methodlarımız yer almaktadır.
Driver,ConfigReader,ReusableMethods,TestBaseRapor,vs... 

### configuration.properties <br/>
Bu properties dosyamızda sürekli kullandığımız variablelar bulunmaktadır. Bu dosyada key=value
olarak olusturduğumuz variableları başka classlara çağırabilmek için utilities packagedan 
ConfigReader classı içindeki method sayesinde bilgileri istediğimiz class a call ederiz.

### pom.xml <br/>
Projemizi build ettigimiz bu dosyada kullanabilcegimiz kodlarin kütüphanesi yer almaktadır.

### Kullanilan Testler
#### EndtoEnd Test
#### Smoke Test
#### Negative Smoke Test



