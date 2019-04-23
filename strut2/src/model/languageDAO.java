package model;

import java.util.List;
import entity.Language;

public interface languageDAO {
	public List<Language> listLanguage();

	public void saveOrUpdateLanguage(Language language);

	public Language listLanguageById(Long Id);

	public void deleteLanguage(Long Id);
}
