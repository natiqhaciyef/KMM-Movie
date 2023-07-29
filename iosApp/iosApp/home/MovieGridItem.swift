//
//  MovieGridItem.swift
//  iosApp
//
//  Created by Natiq Haciyev on 28.07.23.
//  Copyright © 2023 orgName. All rights reserved.
//

import SwiftUI
import shared

struct MovieGridItem: View {
    let movie: MovieModel
    
    var body: some View {
        VStack(alignment: .leading, spacing: 10){
            ZStack{
                AsyncImage(url: URL(string: movie.imageUrl)){
                    image in
                    image.resizable()
                    
                } placeholder: {
                    Color.gray
                }
            }.frame(idealWidth: .infinity, maxWidth: .infinity)
                .clipShape(RoundedRectangle(cornerRadius: 12))
        }.frame(maxWidth: .infinity, maxHeight: 260 )
    }
}

struct MovieGridItem_Previews: PreviewProvider {
    static var previews: some View {
        MovieGridItem(movie: MovieModel(id: 1, title:"Empty", description: "Not selected yet", imageUrl: "", releaseDate: "-"))
    }
}
