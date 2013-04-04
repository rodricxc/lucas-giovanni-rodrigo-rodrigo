package model.dao;

import java.util.List;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import static model.dao.AlunoTurmaDao.PERSISTENCE_UNIT_NAME;
import model.pojo.AlunoTurma;

public interface AlunoTurmaDao {
    static final String PERSISTENCE_UNIT_NAME = "LucasGiovanniRodrigoRodrigo";
    static EntityManagerFactory factory = 
           Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
    
    public boolean add(AlunoTurma alunoTurma);
    public boolean delete(AlunoTurma alunoTurma);
    public AlunoTurma get(int id);
    public List<AlunoTurma> getByTurma(int turmaId);
    public List<AlunoTurma> getByAluno(int alunoId);
    public AlunoTurma getByAmbos(int turmaId, int alunoId);
    public List<AlunoTurma> get();
}
