package model;

import java.util.List;
import entity.Pubhouse;

public interface pubhouseDAO {
	public List<Pubhouse> listPubhouse();

	public void saveOrUpdatePubhouse(Pubhouse pubhouse);

	public Pubhouse listPubhouseById(Long Id);

	public void deletePubhouse(Long Id);
}
