package coreFrame;

import java.io.File;

public class Config {
	private static final int timeToWaitObject = 2;
	private static final String usingBrowser = "Chrome";
	private static String testPath = System.getProperty("user.dir");
	private String framePath = setFramePath();
	private static String currentCaseName;
	private static final String evidenceExtension = ".png";
	private static String baseXPath = "//BrowserApplication//BrowserWindow";
	private static final boolean enableVideoRecorder = false;
	private static Config config = new Config();
	
	private Config(){}
	
	public static Config getInstance(){
		return config;
	}
	
	/**
	 * metodo que retorna o path base do projeto dinamicamente
	 * @return
	 */
	public String getTestPath(){
		return Config.testPath;
	}
	
	/**
	 * metodo que retorna path base do framework
	 * @return
	 */
	public String getFramePath() {
		return framePath;
	}
	
	/**
	 * metodo que define o path base do framework
	 * @param framePath
	 */
	public String setFramePath() {
		File currentDirFile = new File(".");
		return currentDirFile.getAbsolutePath().replace(".", "");
	}
	
	/**
	 * metodo que retorna o browser que será usado
	 * @return
	 */
	public String getUsingBrowser() {
		return Config.usingBrowser;
	}
	
	/**
	 * metodo que retorna o tempo de espera por um objeto
	 * @return
	 */
	public int getTimeToWaitObject() {
		return Config.timeToWaitObject;
	}
	
	/**
	 * metodo que retorna o nome do caso de teste em execução
	 * @return
	 */
	public String getCurrentCaseName() {
		return Config.currentCaseName;
	}
	
	/**
	 * metodo que retorna a extensão em que as evidencias imagens serão salvas
	 * @return
	 */
	public String getEvidenceExtension() {
		return Config.evidenceExtension;
	}
	
	/**
	 * metodo que retorna a xpath base para obter o objeto web
	 * @return
	 */
	public String getBaseXPath() {
		return this.baseXPath;
	}

	/**
	 * metodo que retorna um boolean que habilita ou desabilita a gravação de video do caso de teste
	 * @return
	 */
	public boolean getEnableVideoRecorder () {
		return Config.enableVideoRecorder;
	}
	
	/**
	 * metodo que define o nome do caso de teste que está em execução
	 * @param currentCaseName
	 */
	public void setCurrentCaseName(String currentCaseName) {
		Config.currentCaseName = currentCaseName;
	}
	
	/**
	 * metodo que define o xpath base para obter o objeto web 
	 * @param baseXPath
	 */
	public void setBaseXPath(String baseXPath) {
		Config.baseXPath = baseXPath;
	}
}