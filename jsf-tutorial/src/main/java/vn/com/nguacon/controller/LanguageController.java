package vn.com.nguacon.controller;

import java.io.Serializable;
import java.util.Locale;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

@ManagedBean(name = "languageBean")
@ApplicationScoped
public class LanguageController implements Serializable {

	private static final long serialVersionUID = 1L;
	private static Locale locale = FacesContext.getCurrentInstance().getViewRoot().getLocale();

	public Locale getLocale() {
		return locale;
	}

	public String getLanguage() {
		return locale.getLanguage();
	}

	public void change(String language) {
		System.out.println(language);
		locale = new Locale(language);
		FacesContext.getCurrentInstance().getViewRoot().setLocale(new Locale(language));
	}

}
