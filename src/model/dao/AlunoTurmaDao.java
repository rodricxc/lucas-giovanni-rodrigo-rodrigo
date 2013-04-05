package model.dao;

import java.util.List;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import static model.dao.AlunoTurmaDao.PERSISTENCE_UNIT_NAME;
import model.pojo.Aluno;
import model.pojo.AlunoTurma;
import model.pojo.Turma;

public interface AlunoTurmaDao {
    static final String PERSISTENCE_UNIT_NAME = "LucasGiovanniRodrigoRodrigo";
    static EntityManagerFactory factory = 
           Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
    
    public boolean add(AlunoTurma alunoTurma);
    public boolean delete(AlunoTurma alunoTurma);
    public boolean update(AlunoTurma alunoTurma);
    public AlunoTurma get(int id);
    public List<AlunoTurma> getByTurma(Turma turma);
    public List<AlunoTurma> getByAluno(Aluno aluno);
    public AlunoTurma getByAmbos(Turma turma, Aluno aluno);
    public List<AlunoTurma> get();
}
