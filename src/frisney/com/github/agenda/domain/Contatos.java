package frisney.com.github.agenda.domain;

public class Contatos {
    private static IContatos instance = null;
    private static DataSource dataSource = DataSource.Memory;

    private Contatos(){
    }
    public static IContatos getInstance(){
        return (instance != null)
            ? instance
            : switch (dataSource){
                case Memory -> new ContatosMemoria();
            };
    }
    public static void initialize(DataSource ds){
        dataSource = ds;
    }
}
