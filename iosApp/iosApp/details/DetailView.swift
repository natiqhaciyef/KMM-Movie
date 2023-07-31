//
//  DetailView.swift
//  iosApp
//
//  Created by Natiq Haciyev on 01.08.23.
//  Copyright © 2023 orgName. All rights reserved.
//

import SwiftUI
import shared

struct DetailView: View {
    let backgroundColor : Color = Color(red: 34/255, green: 35/255, blue: 40/255)
    let movie: MovieModel
    var body: some View {
        ScrollView{
            VStack{
                ZStack{
                    AsyncImage(url: URL(string: movie.imageUrl)){ image in
                        image.resizable().scaledToFill()
                    } placeholder: {
                        ProgressView()
                    }
                }.frame(maxWidth: .infinity, minHeight: 300, maxHeight: 300)
                
                
                VStack(alignment: .leading, spacing: 15){
                    Text(movie.title)
                        .font(.title)
                        .foregroundColor(.white)
                        .fontWeight(.bold)
                        .fixedSize(horizontal: false, vertical: true)
                    
                    Button(action: {
                        //
                    }){
                        HStack{
                            Image(systemName: "play.fill").foregroundColor(.white)
                            Text("Start watching now").foregroundColor(.white)
                        }
                    }.frame(maxWidth: .infinity, maxHeight: 45)
                        .padding()
                        .background(.red)
                        .clipShape(RoundedRectangle(cornerRadius: 10))
                    
                    Text("Released date \(movie.releaseDate)".uppercased())
                        .foregroundColor(.white)
                    
                    Text(movie.description_)
                        .font(.body)
                        .foregroundColor(.white)
                        .fixedSize(horizontal: false, vertical: true)
                }.padding(20)
                    .background(backgroundColor)
            }.frame(maxWidth: .infinity, maxHeight: .infinity)
        }.background(backgroundColor)
    }
}

