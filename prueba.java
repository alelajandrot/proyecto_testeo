package terranova;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class prueba {

    private WebDriver driver;

    public static void main(String[] args) {
        prueba test = new prueba();
        test.setUp();
        test.prueba_folders();
        test.tearDown();
    }

    
	public void setUp() {
        // Configurar el controlador de Firefox
        WebDriverManager.firefoxdriver().setup();
        FirefoxOptions options = new FirefoxOptions();
        //options.addArguments("--headless");
        driver = new FirefoxDriver(options);
    }
	 
    public void prueba_folders() {
    	
    	//---------------verificar que funcione el usuario-----------------
    	driver.get("https://qa-challenge.ensolvers.com");
        //caso de uso 1
    	//probar el flujo alternativo
    	
    	//flujo normal
    	WebElement usernameField1 = driver.findElement(By.name("username"));
        WebElement passwordField1 = driver.findElement(By.name("password"));
        WebElement loginButton1 = driver.findElement(By.xpath("//button[@type='submit']"));
        
        usernameField1.sendKeys("alejandro");
        passwordField1.sendKeys("alejandro");
        loginButton1.click();
        
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        
        WebElement usernameField = driver.findElement(By.name("username"));
        usernameField.clear();
        WebElement passwordField = driver.findElement(By.name("password"));
        passwordField.clear();
        WebElement loginButton = driver.findElement(By.xpath("//button[@type='submit']"));
        
        usernameField.sendKeys("user");
        passwordField.sendKeys("user");
        loginButton.click();
        
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        
        //-----------verficiar las funcionalidades de folders -------------------------------
        
        WebElement button2 = driver.findElement(By.xpath("//*[@id=\"app-view-container\"]/div[1]/div/div/div[2]/div/div[2]/div[2]/button"));
        // Hacer clic en el botón de Sign in
        button2.click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        // Mantener el navegador abierto por un tiempo para ver la interacción
        
        WebElement button3 = driver.findElement(By.xpath("//*[@id=\"jh-create-entity\"]"));
        // Hacer clic en el botón de Sign in
        button3.click();
       
        WebElement titlefolder = driver.findElement(By.xpath("//*[@id=\"folder-name\"]"));
        titlefolder.sendKeys("alejandro");
        
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        // Encontrar el botón de guardar utilizando XPath
        WebElement saveButton = driver.findElement(By.xpath("//*[@id=\"save-entity\"]"));
        saveButton.click(); 
        
      //modificar folder caso 3
        WebElement modfolder = driver.findElement(By.xpath("//*[@id=\"app-view-container\"]/div[1]/div/div/div/div/div/table/tbody/tr[1]/td[3]/div/a[2]"));
        modfolder.click();
        
        
       WebElement editarfolder = driver.findElement(By.xpath("//*[@id=\"folder-name\"]"));
       Actions actions = new Actions(driver);

       // Borrar el contenido actual y escribir el nuevo texto
       actions.click(editarfolder)
              .keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL)
              .sendKeys(Keys.DELETE)
              .sendKeys("folder_modify")
              .build()
              .perform();
        
       
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
      
        WebElement saveButtonmodif = driver.findElement(By.xpath("//*[@id=\"save-entity\"]"));
        saveButtonmodif.click();
        
      //funcionalidad de boton view
        WebElement viewfolder = driver.findElement(By.xpath("//*[@id=\"app-view-container\"]/div[1]/div/div/div/div/div/table/tbody/tr/td[3]/div/a[1]"));
       viewfolder.click();
       

       WebElement modview = driver.findElement(By.xpath("//*[@id=\"app-view-container\"]/div[1]/div/div/div/div/a[2]"));
       modview.click();
       
       driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
       
       
       //modificar folder pero desde view
      WebElement editarfolder1 = driver.findElement(By.xpath("//*[@id=\"folder-name\"]"));
      editarfolder1.clear();
      editarfolder1.sendKeys("---modificado view");
       
       driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
     
       WebElement saveButtonmodif1 = driver.findElement(By.xpath("//*[@id=\"save-entity\"]"));
       saveButtonmodif1.click();
       
       
       driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
       
        
        //eliminar folder caso 4
        WebElement deletefolder = driver.findElement(By.xpath("//*[@id=\"app-view-container\"]/div[1]/div/div/div/div/div/table/tbody/tr/td[3]/div/a[3]"));
        deletefolder.click();
      
        WebElement confirmar = driver.findElement(By.xpath("//*[@id=\"jhi-confirm-delete-folder\"]"));
        confirmar.click();
      
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        
        
        // ir a home
        
        WebElement home = driver.findElement(By.xpath("//*[@id=\"header-tabs\"]/li[1]/a"));
        home.click();
      
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        
        //--------------verficiar funcionalidad del boton usuario para modificar y salir de la seccion------------------
        
        WebElement home1 = driver.findElement(By.xpath("//*[@id=\"header-tabs\"]/li[1]/a"));
        home1.click();
        
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        // Encontrar el botón de Sign in utilizando XPath
      
        WebElement signInButton1 = driver.findElement(By.xpath("/html/body/div/div/div/div[2]/nav/div/ul/li[3]/a"));
        // Hacer clic en el botón de Sign in
        signInButton1.click();
        
      //  WebDriverWait wait = new WebDriverWait(driver, 10);
      //  wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("modal fade show")));
        
        WebElement encontrar = driver.findElement(By.xpath("//*[@id=\"account-menu\"]/div"));
        WebElement settings = driver.findElement(By.xpath("//*[@id=\"account-menu\"]/div/a[1]"));
        // Hacer clic en el botón de Sign in
        settings.click();
        
      
      //*[@id="account-menu"]/div/a[1]
        
     // Esperar a que la página de inicio de sesión se procese y se redirija
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
     
      
        WebElement editarfirstname = driver.findElement(By.xpath("//*[@id=\"firstName\"]"));
     // Crear una instancia de Actions
        Actions actions1 = new Actions(driver);

        // Borrar el contenido actual y escribir el nuevo texto
        actions1.click(editarfirstname)
               .keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL)
               .sendKeys(Keys.DELETE)
               .sendKeys("name_modify")
               .build()
               .perform();
        
        WebElement editarlastname = driver.findElement(By.xpath("//*[@id=\"lastName\"]"));
        editarlastname.clear();
        editarlastname.sendKeys("last_name modify");
        
        WebElement editarmailname = driver.findElement(By.xpath("//*[@id=\"email\"]"));
        editarmailname.clear();
        editarmailname.sendKeys("jhon.terranova15@gmail.com");
        
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        
        WebElement saveButtonmod = driver.findElement(By.xpath("//*[@id=\"settings-form\"]/button"));
        saveButtonmod.click();
        
        WebElement home2 = driver.findElement(By.xpath("//*[@id=\"header-tabs\"]/li[1]/a"));
        home1.click();
        
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        
        WebElement button4 = driver.findElement(By.xpath("//*[@id=\"entity-menu\"]/a/span"));
        // Hacer clic en el botón de Sign in
        button4.click();
        
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //para ir a listas de tareas por medio del boton list
        WebElement button5 = driver.findElement(By.xpath("//*[@id=\"entity-menu\"]/div/a[1]"));
        // Hacer clic en el botón de Sign in
        button5.click();
        
      
     
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        
        
        //-------------------------verificar la funcionalidad de los botones de Manage LIST
        
        // ir a home
        
        WebElement home3 = driver.findElement(By.xpath("//*[@id=\"header-tabs\"]/li[1]/a/span"));
        home3.click();
      
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        
        WebElement button7 = driver.findElement(By.xpath("//*[@id=\"entity-menu\"]/a/span"));
        // Hacer clic en el botón de Sign in
        button7.click();
        
        
        // ir a folders por medio del boton list
        WebElement button6 = driver.findElement(By.xpath("//*[@id=\"entity-menu\"]/div/a[2]"));
        // Hacer clic en el botón de Sign in
        button6.click();
        
        WebElement home4 = driver.findElement(By.xpath("//*[@id=\"header-tabs\"]/li[1]/a/span"));
        home4.click();
        
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
      
     // Encontrar el botón de Sign in utilizando XPath
        WebElement signInButton2 = driver.findElement(By.xpath("/html/body/div/div/div/div[2]/nav/div/ul/li[3]/a"));
        // Hacer clic en el botón de Sign in
        signInButton2.click();
        
        WebElement settings1 = driver.findElement(By.xpath("//*[@id=\"account-menu\"]/div/a[1]"));
        // Hacer clic en el botón de Sign in
        settings1.click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        
        
      //------------------------ verificar funcionalidades del boton tarea-------------
        
        WebElement home6 = driver.findElement(By.xpath("//*[@id=\"header-tabs\"]/li[1]/a"));
        home6.click();
        
        // Encontrar el botón de Sign in utilizando XPath
        WebElement signInButton = driver.findElement(By.xpath("//*[@id=\"app-view-container\"]/div[1]/div/div/div[2]/div/div[2]/div[1]/button"));
        // Hacer clic en el botón de Sign in
        signInButton.click();
        
     // Esperar a que la página de inicio de sesión se procese y se redirija
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        
       /* WebElement targetButton = driver.findElement(By.xpath("//*[@id=\"app-view-container\"]/div[1]/div/div/div[2]/div/div[2]/div[1]/button"));
        // Hacer clic en el botón
        targetButton.click();*/
      

     // Esperar a que la página cargue completamente
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        // Encontrar el elemento jh-create-entity CREATE new to do item
        WebElement createEntityButton = driver.findElement(By.xpath("//*[@id=\"jh-create-entity\"]"));
        // Hacer clic en el botón de crear entidad
        createEntityButton.click();
       
     // Esperar a que el formulario de creación de entidad se cargue completamente
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        // Encontrar el campo de título de la entidad utilizando XPath
        WebElement titleField = driver.findElement(By.xpath("//*[@id=\"to-do-item-title\"]"));
        titleField.sendKeys("mi test");
      
        WebElement titleField1 = driver.findElement(By.xpath("//*[@id=\"to-do-item-description\"]"));
        titleField1.sendKeys("describiendo");
        
        WebElement asignfolder = driver.findElement(By.xpath("//*[@id=\"to-do-item-folder\"]"));
        asignfolder.click();
        
        WebElement option = driver.findElement(By.xpath("//*[@id=\"to-do-item-folder\"]/option[2]"));
        option.click();
      
      
        
       /* WebElement titleField3 = driver.findElement(By.xpath("//*[@id=\"to-do-item-folder\"]"));
      
        titleField1.sendKeys("1");*/
     // Esperar a que el formulario de creación de entidad se cargue completamente
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        // Encontrar el botón de guardar utilizando XPath
        WebElement saveButton3 = driver.findElement(By.xpath("//*[@id=\"save-entity\"]"));
        saveButton3.click(); 
        
        //modificar tarea caso 3
        WebElement modtarea = driver.findElement(By.xpath("//*[@id=\"app-view-container\"]/div[1]/div/div/div/div[1]/div/table/tbody/tr/td[5]/div/a[2]"));
        modtarea.click();
        
        
        WebElement editartittle = driver.findElement(By.xpath("//*[@id=\"to-do-item-title\"]"));
        editartittle.clear();
        editartittle.sendKeys("modificado1");
        
        WebElement editardescripcion = driver.findElement(By.xpath("//*[@id=\"to-do-item-description\"]"));
        editardescripcion.clear();
        editardescripcion.sendKeys("modificado1");
        
        WebElement asignfolder1 = driver.findElement(By.xpath("//*[@id=\"to-do-item-folder\"]"));
        asignfolder1.click();
        
        WebElement option1 = driver.findElement(By.xpath("//*[@id=\"to-do-item-folder\"]/option[3]"));
        option1.click();
        
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
      
        WebElement saveButtonmodifica = driver.findElement(By.xpath("//*[@id=\"save-entity\"]"));
        saveButtonmodifica.click();
        
        
        
        //eliminar tarea caso 4
        WebElement deletetarea = driver.findElement(By.xpath("//*[@id=\"app-view-container\"]/div[1]/div/div/div/div[1]/div/table/tbody/tr[1]/td[5]/div/a[3]"));
        deletetarea.click();
      
        WebElement confirm = driver.findElement(By.xpath("//*[@id=\"jhi-confirm-delete-toDoItem\"]"));
        confirm.click();
      
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        
        
        
        //funcionalidad de boton view
         WebElement view = driver.findElement(By.xpath("//*[@id=\"app-view-container\"]/div[1]/div/div/div/div[1]/div/table/tbody/tr/td[5]/div/a[1]"));
        view.click();
        

        WebElement modviewes = driver.findElement(By.xpath("//*[@id=\"app-view-container\"]/div[1]/div/div/div/div/a[2]"));
        modviewes.click();
        
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        
       WebElement editartitle1 = driver.findElement(By.xpath("//*[@id=\"to-do-item-title\"]"));
       	editartitle1.clear();
        editartitle1.sendKeys("modificado view");
        
        WebElement editardescripcion1 = driver.findElement(By.xpath("//*[@id=\"to-do-item-description\"]"));
        editardescripcion1.clear();
        editardescripcion1.sendKeys("modificado view");
        
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
      
        WebElement saveButtonmodif4 = driver.findElement(By.xpath("//*[@id=\"save-entity\"]"));
        saveButtonmodif4.click();
        
        
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        
        
        // ir a home
        
        WebElement home8 = driver.findElement(By.xpath("//*[@id=\"header-tabs\"]/li[1]/a/span"));
        home8.click();
        
        
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        // Mantener el navegador abierto por un tiempo para ver la interacción
        
        // ------------funcionalidad de salir de la aplicacion con usuario---------------
        
        WebElement home5 = driver.findElement(By.xpath("//*[@id=\"header-tabs\"]/li[1]/a"));
        home5.click();
        
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        // Encontrar el botón de Sign in utilizando XPath
      
        WebElement signInButt1 = driver.findElement(By.xpath("/html/body/div/div/div/div[2]/nav/div/ul/li[3]/a"));
        // Hacer clic en el botón de Sign in
        signInButt1.click();
        
      //  WebDriverWait wait = new WebDriverWait(driver, 10);
      //  wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("modal fade show")));
        
        WebElement encontrar1 = driver.findElement(By.xpath("//*[@id=\"account-menu\"]/div"));
        WebElement out = driver.findElement(By.xpath("//*[@id=\"account-menu\"]/div/a[2]"));
        // Hacer clic en el botón de Sign in
        out.click();
        
      
      //*[@id="account-menu"]/div/a[1]
        
     // Esperar a que la página de inicio de sesión se procese y se redirija
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        
        try {
            Thread.sleep(5000); // Espera 5 segundos
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
      
	}
    
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
