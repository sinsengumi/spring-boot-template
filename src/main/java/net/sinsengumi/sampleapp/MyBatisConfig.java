package net.sinsengumi.sampleapp;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

import net.sinsengumi.sampleapp.repository.MakerRepository;

@Configuration
@MapperScan(basePackageClasses = MakerRepository.class)
public class MyBatisConfig {
}
