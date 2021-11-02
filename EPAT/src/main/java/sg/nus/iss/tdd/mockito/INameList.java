package sg.nus.iss.tdd.mockito;

public interface INameList {
  void addName(String name);

  String getName(int index);

  String removeName(String name);

  void clear();
}
