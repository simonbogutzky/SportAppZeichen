import SwiftUI
import Shared

struct ContentView: View {
    @State private var searchText: String = ""
    @State private var disciplines: [Discipline] = []
    
    private let disciplineProvider = DisciplineProvider()
    
    var body: some View {
        TabView {
            Tab("Home", systemImage: "house") {
                Text("Home")
            }
            
            Tab("Catalog", systemImage: "book") {
                List(disciplines, id: \.name) { discipline in
                    Text(discipline.name)
                }
            }
            
            Tab("Settings", systemImage: "gearshape") {
                Text("Settings")
            }
            
            Tab(role: .search) {
                NavigationStack {
                    Text("Search")
                }
            }
        }
        .searchable(text: $searchText)
        .task {
            do {
                disciplines = try await disciplineProvider.fetchDisciplines()
            } catch {
                
            }
        }
    }
}

struct ContentView_Previews: PreviewProvider {
    static var previews: some View {
        ContentView()
    }
}
